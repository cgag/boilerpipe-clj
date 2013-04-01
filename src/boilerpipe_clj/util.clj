(ns boilerpipe-clj.util)

(defn wrap-paragraphs 
  "Wraps the paragraphs of the text in <p> tags."
  [text]
  (clojure.string/replace text #"(.+)" "<p>$1</p>")) 
