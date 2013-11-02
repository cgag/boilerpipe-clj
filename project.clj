(defproject io.curtis/boilerpipe-clj "0.3.0"
  :description "A simple wrapper around the Boilerpipe library for extracting text from html articles/pages"
  :url "http://curtis.io"
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.thnetos/cd-client "0.3.4" :exclusions [org.clojure/clojure cheshire]]
                 [net.sourceforge.nekohtml/nekohtml "1.9.15"]
                 [xerces/xercesImpl "2.9.1"]
                 [de.l3s.boilerpipe/boilerpipe "1.2.0"]]
  :repositories  {"boilerpipe"
                  {:url "http://boilerpipe.googlecode.com/svn/repo/"}})
