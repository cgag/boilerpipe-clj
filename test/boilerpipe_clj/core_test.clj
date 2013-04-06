(ns boilerpipe-clj.core-test
  (:require [clojure.test :refer :all]
            [boilerpipe-clj.core :refer :all]
            [boilerpipe-clj.util :as util]
            [boilerpipe-clj.extractors :as ext]))

(defonce test-article 
  (slurp "./test/boilerpipe_clj/resources/greenspun-test.html"))

(def extractors [ext/default-extractor
                 ext/article-extractor
                 ext/article-sentence-extractor])

;; TODO: Why does lein test say it tests 6400 assertions?
(deftest get-text-extraction
  (testing "get-text extracts something from an article
            without a provided extractor"
    (let [res (get-text test-article)] 
      (is (and 
           (not= res "")
           (not= res nil)))))
  (testing "All the available extractors extract something
           from the article"
    (doseq [ext extractors
            res (get-text test-article ext)]
      (is (and (not= res "")
               (not (nil? res)))))))

;; TODO: Test wrap-paragraphs and get-text-as-html
(deftest test-wrap-paragraphs
  (testing "wrap-paragraphs successfully wraps newline separated paragraphs in <p> tags"
    ))

;; TODO: More fine grained tests for the extractors.  Not sure what these tests would look like.
