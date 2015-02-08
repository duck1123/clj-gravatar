(defproject net.kronkltd/clj-gravatar "0.1.0-SNAPSHOT"
  :description "gravatar api wrapper for clojure"
  :url "https://github.com/duck1123/clj-gravatar"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/data.json "0.1.2"]]
  :codox {:exclude example
          :src-dir-uri "https://github.com/duck1123/clj-gravatar/blob/master"
          :src-linenum-anchor-prefix "L"}
  :profiles {:dev
             {:dependencies
              [[midje "1.6.3"]]}}
  :plugins [[lein-midje "3.1.3"]
            [codox "0.8.10"]])
