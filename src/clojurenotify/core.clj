(ns clojurenotify.core
  (:gen-class))

(defn criar-transacao [nome, valor] {:nome nome :valor valor})

(def transacoes
  [(criar-transacao "venda" 12.99)
   (criar-transacao "compra" 123.45)
   (criar-transacao "venda" -100.)
   (criar-transacao "compra" -1.99)
   (criar-transacao "deposito" 984198198)])

(defn get-valores-a [transacoes-real] (map :valor transacoes-real))

(defn get-valores-b [transacoes-real] (map (fn [x] (:valor x)) transacoes-real))

(defn get-valores-c [transacoes-real] (map #(:valor %) transacoes-real))

(defn calcula-valor [transacoes-real] (reduce + (get-valores-a transacoes-real)))

(defn eh-uma-venda? [transacoes-real] (= "venda" (:nome transacoes-real)))

(defn get-vendas [transacoes-real] (filter eh-uma-venda? transacoes-real))

(defn get-compras [transacoes-real] (filter #(not (eh-uma-venda? %)) transacoes-real))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
