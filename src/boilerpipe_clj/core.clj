(ns boilerpipe-clj.core
  (:require [clojure.string :as s])
  (:import de.l3s.boilerpipe.extractors.ArticleExtractor
           de.l3s.boilerpipe.extractors.DefaultExtractor))

(def ^:dynamic *user-agent* "Mozilla/5.0 (Windows NT 6.1; rv:10.0) Gecko/20100101 Firefox/10.0")

(def article-extractor (ArticleExtractor/getInstance))
(def default-extractor (DefaultExtractor/getInstance))

(defn get-text
  "text-source can be a java.net.URL, a String, a Reader, etc"
  [source & [extractor]]
  (let [extractor (or extractor article-extractor)
        source (slurp source)]
    (.getText extractor source)))

(declare wrap-paragraphs)

(defn get-html [source & [extractor]]
  (-> (get-text source extractor) wrap-paragraphs))

(defn wrap-paragraphs 
  "Wraps the paragraphs of the text in <p> tags."
  [text]
  (let [paragraphs (s/split text #"\n")]
    (->> paragraphs
      (map #(str "<p>" % "</p>"))
      (s/join ""))))
