(ns boilerpipe-clj.core-test
  (:use clojure.test
        boilerpipe-clj.core))

(defonce test-article 
  (slurp "./test/boilerpipe_clj/resources/greenspun-test.html"))

(deftest get-text-extraction
  (testing "that get-text extracts something from an article"
    (let [res (get-text test-article)] 
      (is (and 
            (not= res "")
            (not= res nil))))))
