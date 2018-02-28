(defproject martian "0.1.9-SNAPSHOT"
  :description "Client routing for Swagger APIs"
  :url "https://github.com/oliyh/martian"
  :license {:name "The MIT License"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[frankiesardo/tripod "0.2.0"]
                 [prismatic/schema "1.1.7"]
                 [camel-snake-kebab "0.4.0"]
                 [cheshire "5.8.0"]
                 [com.cognitect/transit-clj "0.8.300"]
                 [com.cognitect/transit-cljs "0.8.243"]
                 [frankiesardo/linked "1.2.9"]]
  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-doo "0.1.8"]]
  :java-source-paths ["src"]
  :javac-options ["-target" "1.8" "-source" "1.8"]
  :profiles {:provided {:dependencies [[org.clojure/clojure "1.9.0"]
                                       [org.clojure/clojurescript "1.9.946"]]}
             :dev {:source-paths ["../test-common"]
                   :exclusions [[org.clojure/tools.reader]]
                   :resource-paths ["test-resources"]
                   :dependencies [[org.clojure/clojure "1.9.0"]
                                  [org.clojure/clojurescript "1.9.946"]
                                  [org.clojure/tools.reader "1.2.2"]
                                  [com.cemerick/piggieback "0.2.2"]]
                   :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}}
  :aliases {"test" ["do" ["clean"] ["test"] ["doo" "nashorn" "test" "once"]]}
  :cljsbuild {:builds [{:id "test"
                        :source-paths ["src" "test"]
                        :compiler {:output-to "target/unit-test.js"
                                   :main 'martian.runner
                                   :optimizations :simple}}]})
