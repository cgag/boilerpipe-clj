(ns boilerpipe-clj.core
  (:require [boilerpipe-clj.extractors :as ext]
            [clojure.java.io :refer [as-url]])
  (:import (de.l3s.boilerpipe.extractors ExtractorBase)))

(defn get-text
  "Takes HTML as String and returns extracted content.

  Will use Boilerpipe ArticleExtractor impl if not passed an extractor
  instance as second argument."
  ([source]
     (get-text source ext/article-extractor))
  ([^String source ^ExtractorBase extractor]
     (.getText extractor source)))

(defn get-images
  "Takes the URL of the page and return list of Image"
  [^String url]
  (.process ext/image-extractor (as-url url) ext/default-extractor))

