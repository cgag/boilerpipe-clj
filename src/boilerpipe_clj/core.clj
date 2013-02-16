(ns boilerpipe-clj.core
  (:require [clojure.string :as s]
            [clj-http [client  :as http]
                      [cookies :as cookies]])
  (:import de.l3s.boilerpipe.extractors.ArticleExtractor
           de.l3s.boilerpipe.extractors.DefaultExtractor))

(def ^:dynamic *user-agent* "Mozilla/5.0 (Windows NT 6.1; rv:10.0) Gecko/20100101 Firefox/10.0")

(def article-extractor (ArticleExtractor/getInstance))
(def default-extractor (DefaultExtractor/getInstance))

(defprotocol TextExtractor
  "Extract the text from a given source"
  (extract-text [source extractor] "Get text from a given source using "))

(extend-protocol TextExtractor
  java.net.URL
  (extract-text [source extractor]
    (try
      (let [cookie-store (cookies/cookie-store)
            resp (http/get (str source) {:cookie-store cookie-store
                                         :headers {"User-Agent" *user-agent*}})
            body-str (:body resp)]
        (extract-text body-str extractor))
      (catch Exception e
        (str "Error fetching " source))))
  Object
  (extract-text [source extractor]
    (.getText extractor source)))

(defn get-text
  "text-source can be a java.net.URL, a String, a Reader, etc"
  [source & [extractor]]
  (let [extractor (or extractor article-extractor)]
    (extract-text source extractor)))

(declare wrap-paragraphs)

(defn get-html [source & [extractor]]
  (let [text (get-text source extractor)]
    (wrap-paragraphs text)))

(defn wrap-paragraphs 
  "Wraps the paragraphs of the text in <p> tags."
  [text]
  (let [paragraphs (s/split text #"\n")]
    (->> paragraphs
      (map #(str "<p>" % "</p>"))
      (s/join ""))))

(defn get-url-text [url]
  (try
    (get-text (java.net.URL. url))
    (catch Exception e
      (str "Invalid url: " url))))
