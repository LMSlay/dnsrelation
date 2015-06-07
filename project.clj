(defproject dnsrelation "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
		             [clojurewerkz/neocons "3.0.0"]
                 [org.clojure/core.logic "0.8.10"]]
  :jvm-opts ["-Xms1024m" "-Xmx2024m"]
  :main ^:skip-aot dnsrelation.cores
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
