(defproject gurunabi-search "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [yogthos/config "1.1.7"]
                 [org.clojure/data.json "0.2.7"]
                 [ring/ring-codec "1.1.0"]]
  :repl-options {:init-ns gurunabi-search.core}
  :jvm-opts ["-Dconfig=dev-config.edn"]
  :main gurunabi-search.core)
