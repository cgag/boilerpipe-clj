(ns boilerpipe-clj.core
  (:require [boilerpipe-clj.extractors :as ext])
  (:require [boilerpipe-clj.util :as util]))

(defn get-text
  "Takes HTML as String and returns extracted content.

  Will use default Boilerpipe Extractor impl if not passed an extractor
  instance as second argument."
  [^String source & [extractor]]
  (if-let [extractor extractor]
    (.getText extractor source)
    (.getText ext/default-extractor source)))

(defn get-text-as-html [^String source & [extractor]]
  "Takes HTML as String and returns extracted content in <p> tags."
  (util/wrap-paragraphs (get-text source extractor)))
