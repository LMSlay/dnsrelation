(ns dnsrelation.core.database
  (:require [clojurewerkz.neocons.rest :as nr]
            [clojurewerkz.neocons.rest.relationships :as nrl]
            [clojurewerkz.neocons.rest.nodes :as nn]))

(def conn  (nr/connect "http://localhost:7474/db/data/"))

(defn search-repeat
  [dns index]
  (let [result (nn/query conn index (str index ":" dns))]
    (if (empty? result)
      nil
      (:id ((into [] result) 0))
      )
    ))

(defn create-dns
  [dns index]
  (let [check (search-repeat dns index)]
    (if (nil? check)
      (let [node (nn/create conn {index dns})] (nn/add-to-index conn (:id node) index index dns) node)
      (nn/get conn check)
      )
    )
  )

(defn create-domain-ip
  [domain ip]
  (let [d (create-dns domain "domain")
       i (create-dns ip "ip")]
    (print (str "insert node" domain " " ip "\n"))
  (nrl/create conn d i :map)
    )
  )


(defn get-in-node
  [nums]
  (let [node (nn/get conn nums)
        in (nrl/incoming-for conn node :map [])
        out (nrl/outgoing-for conn node :map [])]
    (if (empty? in)
      (set (map (fn [x](:type x)) out))
      (set (map (fn [x](:type x)) in)))
  ))

(defn prop-set
  [start end]

  )

(defn add-link
  [start end]

  )


