db.animal.insert({
  "id_animal" : 1,
		"id_cliente" : 1,
		"nome" : "Smith",
		"tipo" : "Cachorro",
		"raca" : "Pitbull",
		"pelagem" : "Curto",
		"porte" : "Medio",
		"idade" : 5,
		"cliente": {
		  "id_cliente" : 1, 
		  "nome" : "mateus castro",
		  "quantidade_pedidos" : 3,
		  "valor_pagamento" : 200.00,
		  "email" : "teste@gmail.com",
		  "id_usuario" : 1
		},

})
{ acknowledged: true,
  insertedIds: { '0': ObjectId("62ec3fc99d6c5a57c6ffce7a") } }

db.animal.insertMany([
  {"id_animal" : 2,
		"id_cliente" : 2,
		"nome" : "Renatin Pilantra",
		"tipo" : "Cachorro",
		"raca" : "Doberman",
		"pelagem" : "Curto",
		"porte" : "Grande",
		"idade" : 3,
		"cliente": {
		  "id_cliente" : 2, 
		  "nome" : "Pedro Henrique",
		  "quantidade_pedidos" : 2,
		  "valor_pagamento" : 150.00,
		  "email" : "phemail@gmail.com",
		  "id_usuario" : 2
		}},
		{"id_animal" : 3,
		"id_cliente" : 3,
		"nome" : "Miau",
		"tipo" : "Gato",
		"raca" : "Laranja",
		"pelagem" : "Medio",
		"porte" : "Pequeno",
		"idade" : 4,
		"cliente": {
		  "id_cliente" : 2, 
		  "nome" : "Pedro Henrique",
		  "quantidade_pedidos" : 2,
		  "valor_pagamento" : 150.00,
		  "email" : "phemail@gmail.com",
		  "id_usuario" : 2
		}}
])
{ acknowledged: true,
  insertedIds: 
   { '0': ObjectId("62ec4bdf9d6c5a57c6ffce7e"),
     '1': ObjectId("62ec4bdf9d6c5a57c6ffce7f") } }

db.animal.find({
  nome: {
    $regex: "ra*",
    $options: "i"
  }
})
{ _id: ObjectId("62ec40129d6c5a57c6ffce7b"),
  id_animal: 2,
  id_cliente: 2,
  nome: 'Renatin Pilantra',
  tipo: 'Cachorro',
  raca: 'Doberman',
  pelagem: 'Curto',
  porte: 'Grande',
  idade: 3,
  cliente: 
   { id_cliente: 2,
     nome: 'Pedro Henrique',
     quantidade_pedidos: 2,
     valor_pagamento: 150,
     email: 'phemail@gmail.com',
     id_usuario: 2 } }

db.animal.find({
	"cliente.nome" : "mateus castro"
})
{ _id: ObjectId("62ec3fc99d6c5a57c6ffce7a"),
  id_animal: 1,
  id_cliente: 1,
  nome: 'Smith',
  tipo: 'Cachorro',
  raca: 'Pitbull',
  pelagem: 'Curto',
  porte: 'Medio',
  idade: 5,
  cliente: 
   { id_cliente: 1,
     nome: 'mateus castro',
     quantidade_pedidos: 3,
     valor_pagamento: 200,
     email: 'teste@gmail.com',
     id_usuario: 1 } }

db.animal.updateOne({
	 nome: "Miau" },
   {
     $set: { "nome": "Miau", pelagem: "Curta" }           
   }
)
{ acknowledged: true,
  insertedId: null,
  matchedCount: 1,
  modifiedCount: 1,
  upsertedCount: 0 }

db.animal.deleteOne( {
	 "nome": "Miau"
})
{ acknowledged: true, deletedCount: 1 }

//AGGREGATE

db.cliente.insertMany( [
   { _id: 0, nome: "Mateus Castro", quantidade_pedidos: "3", valor_pagamento: 200, email: "teste@gmail.com", id_usuario: 0},
   { _id: 1, nome: "Fulano1", quantidade_pedidos: "2", valor_pagamento:  120, email: "fulano1@gmail.com", id_usuario: 1},
   { _id: 2, nome: "Ciclano2", quantidade_pedidos: "1", valor_pagamento:  75, email: "ciclano1@gmail.com", id_usuario: 2},
   { _id: 3, nome: "Beltrano3", quantidade_pedidos: "5", valor_pagamento:  300, email: "beltranao@gmail.com", id_usuario: 3}
] )
{ acknowledged: true,
  insertedIds: { '0': 0, '1': 1, '2': 2, '3': 3 } }

db.cliente.insertMany([
   { _id: 4, nome: "Guile", quantidade_pedidos: "5", valor_pagamento:  300, email: "teste@gmail.com", id_usuario: 4},
   { _id: 5, nome: "Sheila", quantidade_pedidos: "2", valor_pagamento:  120, email: "teste315@gmail.com", id_usuario: 5}])
{ acknowledged: true, insertedIds: { '0': 4, '1': 5 } }

db.cliente.aggregate([
   {$match: { valor_pagamento: 300 } },
   {$group: { _id: "$nome", soma: { $sum: "$id_usuario" } } }
] )
{ _id: 'Guile', soma: 4 }
{ _id: 'Beltrano3', soma: 3 }

db.cliente.aggregate( [
   { $match: { valor_pagamento: 300, nome: { $nin: [ "Guile" ] } }},
   { $group: { _id: "$nome", sumQuantity: {$sum: "$id_usuario" }} }
] )
{ _id: 'Beltrano3', sumQuantity: 3 }


//PROJECTION

db.animal.find( {}, { _id: 0, "nome":1, "tipo":1, "porte":1})
{ nome: 'Smith', tipo: 'Cachorro', porte: 'Medio' }
{ nome: 'Renatin Pilantra', tipo: 'Cachorro', porte: 'Grande' }

