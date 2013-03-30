(ns boilerpipe-clj.extractors 
  (:import (de.l3s.boilerpipe.extractors 
             ArticleExtractor
             DefaultExtractor)))

(defonce article-extractor (ArticleExtractor/getInstance))
(defonce default-extractor (DefaultExtractor/getInstance))
