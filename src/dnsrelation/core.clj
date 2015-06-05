(ns dnsrelation.core
  (:require [clojurewerkz.neocons.rest :as nr]
            [clojurewerkz.neocons.rest.nodes :as nn]
            [clojurewerkz.neocons.rest.cypher :as cy]))

(def conn  (nr/connect "http://localhost:7474/db/data/"))



(defn -main
  [& args]
  ;; creates a node wit two properties
  (print (create-dns "jo22e" "username"))
  )