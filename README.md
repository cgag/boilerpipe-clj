# boilerpipe-clj

A simple wrapper around the Boilerpipe text extraction library.

## Artifacts

`boilerpipe-clj` is [released on Clojars](http://clojars.org).

### The Most Recent Release

With Leiningen, add it to the dependencies in `project.clj`:

```clojure
[io.curtis/boilerpipe-clj "0.2.1"]
```

## Usage

### Core Functionality - boilerpipe-clj.core

The main namespace for Boilerpipe operations in the Clojure wrapper is
`boilerpipe-clj.core`. 

```clojure
user=> (use 'boilerpipe-clj.core)
```

The main function for extracting human-readable text from an HTML document is
`get-text`.

```clojure
user=> (def article (slurp "http://www.newyorker.com/reporting/2013/03/11/130311fa_fact_kolbert?currentPage=all"))
#'user/article
user=> (get-text article) ;;Uses the ArticleExtractor by default; it's tuned for news
"REM Sleep\nNathaniel Kleitman, known as the “father of modern sleep research,” was born in 1895...[redacted]"
```

It expects HTML as a String for its first argument, but you can also opt to use
different strategies for extracting text by passing it an extractor instance as
the second arg.

```clojure
user=> (get-text article boilerpipe-clj.extractors/default-extractor) 
"Some people can’t go to sleep until late; others can’t sleep in. Both suffer “social jet lag.”...[redacted]"
```

### Extraction Strategies - boilerpipe-clj.extractors 

The most frequently used extraction strategies are definied in
`boilerpipe-clj.extractors`. These are

* `ArticleExtractor` - *Default*
* `DefaultExtractor`
* `ArticleSentenceExtractor`

Defining your own strategies is not currently possible from Clojure. Please
refer to the Boilerpipe documentation for more info on implementing them in
Java.

### Utility Functions- boilerpipe-clj.util

Utility functions for pretty-printing results or munging the returned text for
display are currently available in the `boilerpipe-clj.utils` namespace. This
may be subject to change. 

## Contributors
* Curtis Gagliardi ([@cgag](https://github.com/cgag))
* Nick Barnwell ([@nickbarnwell](https://github.com/nickbarnwell))

## License

Copyright © 2013 [Curtis Gagliardi](http://curtis.io/)

Distributed under the Eclipse Public License, the same as Clojure.
