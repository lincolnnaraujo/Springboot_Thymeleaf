DROP TABLE IF EXISTS TAREFA;

-- Criar tabela referente as tarefas do TO-DO List
CREATE TABLE TAREFA(
    id_tarefa NUMBER IDENTITY NOT NULL PRIMARY KEY,
    titulo_tarefa VARCHAR2(25) NOT NULL,
    dsc_tarefa VARCHAR2(100) NOT NULL,
    flg_conclusao CHAR(1) DEFAULT 'N',
    data_criacao DATETIME,
    data_atualizacao DATETIME
);

INSERT INTO TAREFA VALUES (default, 'Título Teste 1', 'Descrição Teste 1', 'N', SYSDATE, NULL);
INSERT INTO TAREFA VALUES (default, 'Título Teste 2', 'Descrição Teste 2', 'N', SYSDATE, NULL);
INSERT INTO TAREFA VALUES (default, 'Título Teste 3', 'Descrição Teste 3', 'N', SYSDATE, NULL);