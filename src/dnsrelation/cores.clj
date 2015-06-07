(ns dnsrelation.cores
  (:require [dnsrelation.core.database :as db]
            [clojurewerkz.neocons.rest :as nr]
            [clojurewerkz.neocons.rest.relationships :as nrl]
            [clojurewerkz.neocons.rest.nodes :as nn]))

(def conn  (nr/connect "http://localhost:7474/db/data/"))


(defn sub-entity
  [x]
  (print (str "hello " x))
  )


(defn -main
  [& args]
  ;; creates a node wit two properties
  ;;  (data-load-smail (str "/Users/slay/project/clojure/dnsrelation/src/dnsrelation/" (path 0)) dns-deal-test)
  ;;  (db/create-domain-ip "wwwwww" "hhhhh")
  ;;  (print (nn/traverse conn 957 :relationships [{:direction "in" :type "map"}]))
  (print (db/get-in-node 957))
  )