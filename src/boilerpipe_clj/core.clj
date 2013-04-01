(ns boilerpipe-clj.core
  (:require [boilerpipe-clj.extractors :as ext])
  (:require [boilerpipe-clj.util :as util]))

(defn get-text
  "Takes HTML as String and returns extracted content.

  Will use Boilerpipe ArticleExtractor impl if not passed an extractor
  instance as second argument."
  ([^String source extractor]
   (.getText extractor source))

  ([^String source]
   (get-text source ext/article-extractor)))

(defn get-text-as-html [^String source & [extractor]]
  "Takes HTML as String and returns extracted content in <p> tags."
  (util/wrap-paragraphs (get-text source extractor)))
