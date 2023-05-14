A aplicação é um sistema simples para gerenciar o estoque de produtos em uma loja. 
Ela foi desenvolvida com o objetivo de facilitar as operações de 
adicionar produtos ao estoque, remover produtos, atualizar a quantidade em estoque e exibir o estoque atual.

A estrutura principal da aplicação é baseada em uma árvore binária de busca, onde cada nó da árvore representa um produto 
armazenado no estoque. A classe ProductTree é responsável por gerenciar essa árvore, fornecendo métodos para adicionar produtos,
remover produtos, atualizar a quantidade de produtos e buscar produtos específicos na árvore.

A classe Product representa um produto individual e possui atributos como 
código, nome, quantidade em estoque e preço unitário. 
Ela é utilizada para criar objetos de produtos que serão inseridos na árvore.

A classe TreeNode é responsável por representar um nó na árvore. 
Cada nó contém um objeto Product, bem como referências para os nós filhos esquerdo e direito. 
Essa classe é utilizada pela classe ProductTree para construir a estrutura da árvore e realizar as operações de 
adição, remoção, atualização e busca.

A classe Utils contém métodos utilitários, como o método displayProduct, 
que permite exibir as informações de um produto de forma formatada.
Essa classe é utilizada pela classe InventoryManagementSystem para exibir as informações dos produtos ao usuário.

A classe InventoryManagementSystem é responsável por coordenar as funcionalidades do sistema. 
Ela possui métodos para interagir com o usuário, como adicionar um produto, remover
um produto, atualizar a quantidade de um produto e exibir o estoque atual. 
Esses métodos interagem com a estrutura de árvore de produtos da classe ProductTree para realizar as operações desejadas.

A classe Main é a classe principal da aplicação, onde está o método main. 
Ela é responsável por criar uma instância do InventoryManagementSystem e apresentar um menu de opções para 
o usuário interagir com o sistema. O usuário pode escolher as opções do menu digitando 
um número correspondente a cada funcionalidade. 
A classe Main também utiliza a classe Scanner para receber as entradas do usuário.

No geral, a aplicação utiliza a estrutura de árvore binária de busca para organizar e 
gerenciar os produtos do estoque de forma eficiente. Ela oferece uma interface simples para o usuário 
realizar operações de gerenciamento do estoque, garantindo a adição, remoção, atualização e exibição dos produtos
de maneira conveniente e organizada.
