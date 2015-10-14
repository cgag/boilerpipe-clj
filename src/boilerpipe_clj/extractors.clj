(ns boilerpipe-clj.extractors
  (:import (de.l3s.boilerpipe.extractors
             ArticleExtractor
             ArticleSentencesExtractor
             DefaultExtractor)))

(defonce article-extractor (ArticleExtractor/getInstance))
(defonce default-extractor (DefaultExtractor/getInstance))
(defonce article-sentence-extractor
  (ArticleSentencesExtractor/getInstance))
