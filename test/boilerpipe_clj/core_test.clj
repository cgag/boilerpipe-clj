(ns boilerpipe-clj.core-test
  (:require [clojure.test :refer :all]
            [boilerpipe-clj.core :refer :all]
            [boilerpipe-clj.extractors :as ext]))

(defonce test-article
  (slurp "./test/boilerpipe_clj/resources/greenspun-test.html"))

(def extractors [ext/default-extractor
                 ext/article-extractor
                 ext/article-sentence-extractor])

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
            :let [res (get-text test-article ext)]]
      (is (and (not= res "")
               (not (nil? res)))))))
