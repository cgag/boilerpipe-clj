(ns boilerpipe-clj.extractors
  (:import (de.l3s.boilerpipe.extractors
             ArticleExtractor
             ArticleSentencesExtractor
             DefaultExtractor)
             (de.l3s.boilerpipe.sax ImageExtractor)))

(defonce article-extractor (ArticleExtractor/getInstance))
(defonce default-extractor (DefaultExtractor/getInstance))
(defonce image-extractor (ImageExtractor/INSTANCE))
(defonce article-sentence-extractor
  (ArticleSentencesExtractor/getInstance))
