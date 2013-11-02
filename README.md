# boilerpipe-clj

A simple wrapper around the Boilerpipe text extraction library.

## Artifacts

`boilerpipe-clj` is [released on Clojars](http://clojars.org).

### The Most Recent Release

With Leiningen, add it to the dependencies in `project.clj`:

```clojure
[io.curtis/boilerpipe-clj "0.3.0"]
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
user=> (def article (slurp "https://help.github.com/articles/open-source-licensing"))
#'user/article
user=> (get-text article)
"all\nPublic repositories on GitHub are often used to share open source software. Open source software is software that is licensed so that others are free to use, change, [...]"
```

It expects HTML as a String for its first argument, but you can also opt to use
different strategies for extracting text by passing it an extractor instance as
the second arg.

```clojure
user=>  (get-text article boilerpipe-clj.extractors/default-extractor)
"Open source licensing\nWhich license is right for me?!\nDon't fret! Choosing an open source license can be confusing. That's why we created choosealicense.com , a website that helps you make decisions about how to license your code. [...]"
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

## Contributors
* Curtis Gagliardi ([@cgag](https://github.com/cgag))
* Nick Barnwell ([@nickbarnwell](https://github.com/nickbarnwell))

## License

Copyright © 2013 [Curtis Gagliardi](http://curtis.io/)
Copyright © 2013 [Nick Barnwell](https://github.com/nickbarnwell)

boilerpipe-clj is provided under the ASL 2.0 license.

The full license is available in LICENSE.md

## Changes

### 0.3.0

Remove util namespace, it's outside the scope of this library.  It only made it in here
due to lazyness when pulling this code out of another project. I suspect no one but me
was using them anyway. 
