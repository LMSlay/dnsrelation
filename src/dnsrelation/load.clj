(ns dnsrelation.load
  (require [clojure.string :as str]))

;; data example: www.baidu.com,127.0.0.1
(def path ["dataset/10086.txt" "dataset/sub.txt" "dataset/main.txt"])


(defn dns-hash
  [dns]
  (str/join " "(map str (vec dns)))
  )

(defn dns-deal-test
  [dns]
  (let [x (str/split dns #",")]
    (print (into [] (map dns-hash x)))
    )
  )


(defn data-load
  [path deal]
  (with-open [rdr (clojure.java.io/reader path)]
    (doall (map deal (line-seq rdr)))
    )
  )

(data-load (path 0) dns-deal-test)