(ns boilerpipe-clj.core
  (:require [boilerpipe-clj.extractors :as ext])
  (:require [boilerpipe-clj.util :as util])
  (:import (de.l3s.boilerpipe.extractors ExtractorBase)))

(defn get-text
  "Takes HTML as String and returns extracted content.

  Will use Boilerpipe ArticleExtractor impl if not passed an extractor
  instance as second argument."
  ([source]
     (get-text source ext/article-extractor))
  ([^String source ^ExtractorBase extractor]
     (.getText extractor source)))

(defn get-text-as-html [source & [extractor]]
  "Takes HTML as String and returns extracted content in <p> tags."
  (util/wrap-paragraphs (if extractor
                          (get-text source extractor)
                          (get-text source))))
