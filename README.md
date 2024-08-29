# RMI

## Especificação de Trabalho
A partir do código-fonte exemplo de RMI apresentado em aula, desenvolver um sistema de
replicação em Banco de Dados (replicação ativa) baseado no conceito de comunicação em
grupo.

O grupo tem um Líder (iniciando com o ID 0) e permite novos membros solicitem adesão ao
grupo. Todos os testes devem utilizar 3 membros do grupo. Cada membro deve estar
associado a uma base de dados.

Deve-se criar uma interface de cliente SQL que ao se enviar um comando envie ao Líder do
Grupo. O Líder do Grupo deve enviar a mensagem ao grupo, observando a entrega uniforme.
Um comando SQL entregue como mensagem será executado na ordem definida pelo grupo.
Desta forma a replicação ativa será realizada baseada na comunicação em grupo.
O Líder deve ter um mecanismo de detecção de defeito dos Membros, excluindo o membro
defeituoso do grupo. Não é necessário implementar a detecção de falhas do líder e a eleição.
