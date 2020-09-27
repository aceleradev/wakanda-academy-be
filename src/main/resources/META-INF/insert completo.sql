insert into journeys (code, description , name , standard)
values("FULL_STACK_ALL","Lógica, Front Angular e Back Java","Full Stack Completo",1);

insert into tribes (id, code, description , name)
values
	(1 ,"LOGICA","Tribo especilista em Lógica de programação","Tribo da Fronteira"),
	(2 ,"MARCACAO_ESTILO","Tribo especilista em Construir e Estilizar Páginas","Tribo da Guarda Real"),
	(3 ,"JAVASCRIPT","Tribo especilista em Desenvolver WebAPP Nativas","Tribo dos Comerciantes"),
	(4 ,"ANGULAR","Tribo especilista em Desenvolver WebAPP com Angular","Tribo do Rio"),
	(5 ,"JAVA","Tribo especilista em Java","Tribo do Jabari"),
	(6 ,"JAVA_PERSISTENCIA","Tribo especilista em Dados","Tribo dos Mineradores"),
	(7 ,"JAVA_API","Tribo especilista em Construir API's Web's","Tribo dos Cães de Guerra");

insert into journeys_tribes (journey_id,tribe_id,`sequence`) 
values 
	(1,1,1),
	(1,2,2),
	(1,3,3),
	(1,4,4),
	(1,5,5),
	(1,6,6),
	(1,7,7);
	
INSERT INTO skills (code,description,name,tribe_sequence,tribe_id) VALUES 
('LOGICA-01',NULL,'Curso de Lógica de programação I - Os primeiros programas com Javascript e HTML',1,1)
,('LOGICA-02',NULL,'Curso de Lógica de programação II - pratique com desenhos, animações e um jogo',2,1)
,('JOGOS-01',NULL,'Jogos clássicos parte 1 Iniciando no Javascript com Pong',3,1)
,('JOGOS-02',NULL,'Jogos clássicos parte 2 laços e listas com Javascript',4,1)
,('HTML-01',NULL,'HTML5 e CSS3 parte 1 A primeira página da Web',1,2)
,('HTML-02',NULL,'HTML5 e CSS3 parte 2 Posicionamento, listas e navegação',2,2)
,('HTML-03',NULL,'HTML5 e CSS3 parte 3 Trabalhando com formulários e tabelas',3,2)
,('HTML-04',NULL,'HTML5 e CSS3 parte 4 Avançando no CSS',4,2)
,('WEB-RESPONSIVA',NULL,'Web Design Responsivo Páginas que se adaptam do mobile ao desk',5,2)
,('BOOTSTRAP4',NULL,'Bootstrap 4 Criando uma landing page responsiva',6,2)
;
INSERT INTO skills (code,description,name,tribe_sequence,tribe_id) VALUES 
('HTTP',NULL,'HTTP Entendendo a web por baixo dos panos',1,3)
,('JAVASCRIPT-BASICO',NULL,'JavaScript Programando na linguagem da web',2,3)
,('JAVASCRIPT-AVANCADO-01',NULL,'JavaScript avançado I ES6, orientação a objetos e padrões de projetos',3,3)
,('JAVASCRIPT-AVANCADO-02',NULL,'JavaScript avançado II ES6, orientação a objetos e padrões de projetos',4,3)
,('TYPESCRIPT-01',NULL,'TypeScript parte 1 Evoluindo seu Javascript',5,3)
,('TYPESCRIPT-02',NULL,'TypeScript parte 2 Mais técnicas e boas práticas',6,3)
,('WEBPACK',NULL,'Webpack Manipulando módulos na sua webapp',1,4)
,('ANGULAR-01',NULL,'Angular parte 1 Fundamentos',2,4)
,('ANGULAR-02',NULL,'Angular parte 2 Autenticação, Forms e lazy loading',3,4)
,('ANGULAR-03',NULL,'Angular parte 3 upload, build e novos componentes',4,4)
;
INSERT INTO skills (code,description,name,tribe_sequence,tribe_id) VALUES 
('ANGULAR-04',NULL,'Angular parte 4 lapidando o projeto',5,4)
,('ANGULAR-JASMINE',NULL,'Angular parte 4 lapidando o projeto',6,4)
,('JAVA-01',NULL,'Java parte 1 Primeiros passos',1,5)
,('JAVA-02',NULL,'Java parte 2 Introdução à Orientação a Objetos',2,5)
,('JAVA-03',NULL,'Java parte 2 Introdução à Orientação a Objetos',3,5)
,('JAVA-04',NULL,'Java parte 4 Entendendo exceções',4,5)
,('JAVA-05',NULL,'Java parte 5 Pacotes e java.lang',5,5)
,('JAVA-06',NULL,'Java parte 6 Conhecendo o java.util',6,5)
,('JAVA8',NULL,'Java 8 Tire proveito dos novos recursos da linguagem',7,5)
,('POSTGRESQL',NULL,'Introdução ao PostgreSQL Primeiros passos com SQL',1,6)
;
INSERT INTO skills (code,description,name,tribe_sequence,tribe_id) VALUES 
('JAVA-JDBC',NULL,'Java e JDBC Trabalhando com um banco de dados',2,6)
,('JAVA-JPA',NULL,'Java e JPA Persista seus objetos com a JPA2 e Hibernate',3,6)
,('MAVEN',NULL,'Maven Build do zero a web',1,7)
,('SERVLET-01',NULL,'Servlet Parte 1 Fundamentos da programação web Java',2,7)
,('SERVLET-02',NULL,'Servlet parte 2 Autenticação, autorização e o padrão MVC',3,7)
,('SPRING-BOOT-01',NULL,'Spring Boot Parte 1 Construa uma API Rest',4,7)
;

INSERT INTO lessons (code,difficulty,file_id,link,name,skill_sequence,skill_id) VALUES 
('LOGICA-01-1',1.77778,'1hvV4KqngHMoAzP4D3vUwlERV5dc1PDlx',NULL,'Comece a programar hoje',1,1)
,('LOGICA-01-2',1.77778,'1QOV-q1uOkUVJXo8LnZ_rx2T9sYZvgvQe',NULL,'Comunique-se com o usuário',2,1)
,('LOGICA-01-3',1.77778,'1I1SOm9VfR41OhCyEEHdmHXhjhQdsPy2J',NULL,'Torne seu programa dinâmico com variáveis',3,1)
,('LOGICA-01-4',1.77778,'1YSjwrKjOD2ML3Q6XRLB5FnNfhPQb6ZaG',NULL,'Crie suas próprias funcionalidades',4,1)
,('LOGICA-01-5',1.77778,'1DUtGHOZb07yj4hU4BAG37o6hMMWEO3yp',NULL,'Pratique resolvendo problemas do seu dia a dia',5,1)
,('LOGICA-01-6',1.77778,'13sbV1zHzcqIaKz1F7DJBhi4ip3tLz5sD',NULL,'Execute códigos diferentes dependendo da condição',6,1)
,('LOGICA-01-7',1.77778,'1614BqAz7oUuKN0X11kSKFjyer1ZDdONQ',NULL,'Repita tarefas',7,1)
,('LOGICA-01-8',1.77778,'1sV62dr-3903VgE0TzYHDu-wuio0-hiET',NULL,'Interaja de maneira diferente com o usuário',8,1)
,('LOGICA-01-9',1.77778,'1Zyck5C5RE6bymbu3AsyleNRkVXdC-Ikl',NULL,'Trabalhe com muitos dados',9,1)
,('LOGICA-02-1',1.66667,'1tUnMnGQhROoZ-lbxZvOo6y8C_KiBUIfv',NULL,'Desenhando gráficos com Canvas',1,11)
;
INSERT INTO lessons (code,difficulty,file_id,link,name,skill_sequence,skill_id) VALUES 
('LOGICA-02-2',1.66667,'1mI_ZSoRNb7vMCEv8SsI-01lmiYR7c9u7',NULL,'Extraindo funções',2,11)
,('LOGICA-02-3',1.66667,'1CLph8mi-uiS_pUzBiF_m8Nd5B7pGJUdN',NULL,'Interagindo com o usuário',3,11)
,('LOGICA-02-4',1.66667,'1fzRXviokdfm1pvDHUCicfxe6YHqIkd_g',NULL,'Movendo elementos animações simples',4,11)
,('LOGICA-02-5',1.66667,'1NKPmfbQ__JhsRA9j2U10J46E8s3atMAO',NULL,'Nosso primeiro jogo',5,11)
,('LOGICA-02-6',1.66667,'1z7H-SglZ-Bx7qjxIF-AbgdOpiY12_v6U',NULL,'Por que começar com JavaScript',6,11)
,('JOGOS-01-1',1.2,'1C_lkJcIoDOc0G09AH1_8T7qdif2Orju9',NULL,'Pong no Scratch',1,21)
,('JOGOS-01-2',1.2,'1IhAfNNUjuXXDSVcFRHrdi0Oy5pPBHJ-n',NULL,'Iniciando no javascript',2,21)
,('JOGOS-01-3',1.2,'1Ce2wlFg-MsbGnyTjoWz015i3PGy2vLNJ',NULL,'Criando minha raquete no jogo',3,21)
,('JOGOS-01-4',1.2,'1Mtpf0bxg9kJa4L1LSK0UmjfGEcdtOrBr',NULL,'Criando a raquete do oponente',4,21)
,('JOGOS-01-5',1.2,'1ploxwKIHYzjcvXa5lmqgnYbE3iLnKRa_',NULL,'Editando placar e adicionando sons',5,21)
;
INSERT INTO lessons (code,difficulty,file_id,link,name,skill_sequence,skill_id) VALUES 
('JOGOS-02-1',0.8,'108IikvEr_YLwdax5ZBDtY6Op1Cti-VQX',NULL,'Iniciando o projeto',1,31)
,('JOGOS-02-2',0.8,'1gsmH1roI5lA5ob2pMDhawNSCe1iEqydW',NULL,'Dividindo o código e carros para sempre',2,31)
,('JOGOS-02-3',0.8,'179omgZ-L1nOIbNU6fajPgINd56P4qbF_',NULL,'Listas e laços de repetição',3,31)
,('JOGOS-02-4',0.8,'1UrmVpF0g6x6JXqwLPPurdqfGI3rmJ1HN',NULL,'Colisão, + carros e pontos',4,31)
,('JOGOS-02-5',0.8,'1MbSwjnVgTkATguELZoBdkyNmTOgDV5aZ',NULL,'Adicionando sons e pontos negativos',5,31)
,('HTML-01-1',1.33333,'1dZvlmicdO6jH0b-yNYYU-RD3fF5LOon4',NULL,'Marcação do primeiro texto',1,41)
,('HTML-01-2',1.33333,'1VGVEhx4-dAgd3EnVOXcDZAjn4jeDlEHf',NULL,'Separando o conteúdo e informações',2,41)
,('HTML-01-3',1.33333,'1EQNyilMe4JdHvuXuIbduoBZIbBqHXgpk',NULL,'Trabalhando com CSS',3,41)
,('HTML-01-4',1.33333,'1_Q8k-sZpVhWno362olwJ0Lkufx7RQlwj',NULL,'Estilizando imagens',4,41)
,('HTML-01-5',1.33333,'1-qX8NTzF8cupaXDcyEUfC7mO5KeBofwn',NULL,'Listas e divisões de conteúdo',5,41)
;
INSERT INTO lessons (code,difficulty,file_id,link,name,skill_sequence,skill_id) VALUES 
('HTML-01-6',1.33333,'1eEXUl4aPJBynITz9oqTKxs4swGSapTpG',NULL,'Finalizando a página',6,41)
,('HTML-02-1',1.14286,'1y8bB5GTg1KuLbM1sHouPbNoZUDOFu1LK',NULL,'Criando uma nova página',1,51)
,('HTML-02-2',1.14286,'1Fr-ikqSnPkYyPEfZgAn2MfL9CR5EwGmo',NULL,'Navegação entre páginas',2,51)
,('HTML-02-3',1.14286,'1odTS0oNtV6FRObu2i_6gnCxABwJ6i3JQ',NULL,'Posicionamento dos elementos',3,51)
,('HTML-02-4',1.14286,'1XEU0qfMsYgQAbBmMJB2BswlyKqjzFYL7',NULL,'A tag section',4,51)
,('HTML-02-5',1.14286,'1RIKCAWv_pgr9CWM-ShmxajrXlNylfaNU',NULL,'Lidando com bordas',5,51)
,('HTML-02-6',1.14286,'1oP0N7gvsr-l4ZatZbBWwYNgMA4GUgeCZ',NULL,'Pseudo-classes CSS',6,51)
,('HTML-02-7',1.14286,'1uG2ehF05VpiJyP1UmN4FVAgdbb3S0gdE',NULL,'Finalizando a página de produtos',7,51)
,('HTML-03-1',1.33333,'1L8qXPxHAiUc6D6PgHfZhUGekemFe91tq',NULL,'Criando uma nova página',1,61)
,('HTML-03-2',1.33333,'1w9Td74awxlm6GeYhHUeDPU995SVq6ONr',NULL,'Começando um formulário',2,61)
;
INSERT INTO lessons (code,difficulty,file_id,link,name,skill_sequence,skill_id) VALUES 
('HTML-03-3',1.33333,'1iUuHTpNE_ZRsROhyJM7yR5jNRUIOkQxB',NULL,'Tipos de campos diferentes',3,61)
,('HTML-03-4',1.33333,'142hn35XwmdvAreHOZahEYs0V48Bh7Rlh',NULL,'Melhorando a semântica',4,61)
,('HTML-03-5',1.33333,'1DozeW5KnKWgY6LRMog5LzFWbNIT-cHRM',NULL,'CSS avançado',5,61)
,('HTML-03-6',1.33333,'1Bz7XkGaeCaVuix1qEZLgH2jNU181mKFG',NULL,'Estrutura de tabelas',6,61)
,('HTML-04-1',1.33333,'1GfjWzqbt3k9Mdbs5EP-V4fU1S_FUc0A0',NULL,'Adaptando a página inicial',1,71)
,('HTML-04-2',1.33333,'1QiCg0S3pAOF9ozKmWAxAMPGSXkR7kJlU',NULL,'Conteúdo externo',2,71)
,('HTML-04-3',1.33333,'1c5dStjaEgM3nqDnK4PzJq56mYk-uTd9W',NULL,'Melhorando o CSS',3,71)
,('HTML-04-4',1.33333,'19gv-chZ0OD6vsOW3Zj7n9VF8N9CisR1O',NULL,'Selecionando qualquer coisa',4,71)
,('HTML-04-5',1.33333,'1ePCJmtOEHRNx2cu338vp0wlhyuhlk5Tl',NULL,'Opacidade e sombra',5,71)
,('HTML-04-6',1.33333,'11T2e9bcbqtx-fRvM-CZyCaenPnRQ8Vzb',NULL,'Design responsivo',6,71)
;
INSERT INTO lessons (code,difficulty,file_id,link,name,skill_sequence,skill_id) VALUES 
('WEB-RESPONSIVA-1',1.25,'11ZSIwBGsrhZI4jHwTisqFrYDz61ngmW2',NULL,'Design Fluído',1,81)
,('WEB-RESPONSIVA-2',1.25,'1cM-8KKEuDStn3ieUsNjEnCkOy7hyDG_K',NULL,'Mais Design Fluído',2,81)
,('WEB-RESPONSIVA-3',1.25,'1NjGEpeIF2rFnAOWVdhB7f38dar4CV-wQ',NULL,'Media Queries',3,81)
,('WEB-RESPONSIVA-4',1.25,'13EFCwm1hzZ67DrvOyaIg80XWn2uPCJ-D',NULL,'Workflow & Viewport',4,81)
,('WEB-RESPONSIVA-5',1.25,'1UNK2AfiE62XF5isJkGXAAXaHA2xEZff-',NULL,'Menu Responsivo',5,81)
,('WEB-RESPONSIVA-6',1.25,'1dy1eBUwycVGC8lWzVw5Oas95zV-aT5KD',NULL,'Imagens Responsivas',6,81)
,('WEB-RESPONSIVA-7',1.25,'1Wp0GNGfFCwZj_5I_7yYTlJ2M70VqfOz2',NULL,'Imagens vetoriais',7,81)
,('WEB-RESPONSIVA-8',1.25,'132rrgGiyg51_uEmRwy4lZ-UP3tp9JSle',NULL,'Dicas de UX para Mobile',8,81)
,('BOOTSTRAP4-1',1.33333,'1sa9Awz_aOq-xsH57g5bU3aY53n16nRMM',NULL,'Instalando o bootstrap e implementando a navbar',1,91)
,('BOOTSTRAP4-2',1.33333,'1NcBu1tmIsPdWqpVUnPo2zweQz9HlIsz_',NULL,'Adicionando o carrossel e resolvendo bugs',2,91)
;
INSERT INTO lessons (code,difficulty,file_id,link,name,skill_sequence,skill_id) VALUES 
('BOOTSTRAP4-3',1.33333,'17gcoIsQAlZ25VNVFnabnZO0v4ks0Tvnz',NULL,'Títulos, textos e ferramentas de espaçamento',3,91)
,('BOOTSTRAP4-4',1.33333,'1iz69X-O1aOrhwLpbcl5pOwViBrUFytGM',NULL,'Conhecendo o HTML semântico e inserindo cards',4,91)
,('BOOTSTRAP4-5',1.33333,'1NHID2t_apjEEpGBocAkx7qfVsq-OwLmB',NULL,'Alinhando elementos com Bootstrap Grid',5,91)
,('BOOTSTRAP4-6',1.33333,'12MjjnpHrLohPN1ac-edmhoUir644B_Ob',NULL,'Modais e últimos ajustes',6,91)
,('HTTP-1',1.75,'1WTeS36L6-XbSJ1zQOcEu5H5kWrmsBiA3',NULL,'O que é HTTP',1,101)
,('HTTP-2',1.75,'1Ek9bQQjADlkwnCh9yBuI8uh5ejVOTSul',NULL,'A web segura - HTTPS',2,101)
,('HTTP-3',1.75,'1qkYgK48Nk6sm6Xl-nNGy4F46PWB-obU3',NULL,'Endereços sob seu domínio',3,101)
,('HTTP-4',1.75,'1mgdJj1299YWMFX7uwKKKjhbBKzF7BTTZ',NULL,'O cliente pede e o servidor responde',4,101)
,('HTTP-5',1.75,'1czIRNmAWbn2vWOhz_MS0jL5Q0Waa8aNZ',NULL,'Depurando a requisição HTTP',5,101)
,('HTTP-6',1.75,'1_zFEnDCCUY_3EXkWZqxnnzn88WopuamI',NULL,'Parâmetros da requisição',6,101)
;
INSERT INTO lessons (code,difficulty,file_id,link,name,skill_sequence,skill_id) VALUES 
('HTTP-7',1.75,'1-i9UW0FAGECkI_j88f1_0WW62-LFc_ss',NULL,'Serviços na web com REST',7,101)
,('HTTP-8',1.75,'1jEwhlLkcvidIKS9-JAnUvf4CXn7wClDr',NULL,'HTTP2 - Por uma web mais eficiente',8,101)
,('JAVASCRIPT-BASICO-1',2.22222,'1ZBg61gNtmGHHJ0K95s3e4TKA3ywInitX',NULL,'Introdução',1,111)
,('JAVASCRIPT-BASICO-2',2.22222,'19Zll74Nn-dEnNyPrenqHy_c5sF35rv35',NULL,'Variáveis e Operadores',2,111)
,('JAVASCRIPT-BASICO-3',2.22222,'1G2-7-Emzg8erzK2s7vchpZnzOJkzz5bK',NULL,'Arrays, Loop e Estilos',3,111)
,('JAVASCRIPT-BASICO-4',2.22222,'1zMra69MZ-tTSgFIO7R2p8icZWCfOXpiY',NULL,'Eventos, Formulários e Criando Elementos',4,111)
,('JAVASCRIPT-BASICO-5',2.22222,'1MN8NlinyLq6IHUtITzKa6GpecSyQ6nJY',NULL,'Boas Práticas com Javascript',5,111)
,('JAVASCRIPT-BASICO-6',2.22222,'1f6009W_MR4yvyQWCRxwDIY4IDKTEqX_R',NULL,'Validação de Formulários',6,111)
,('JAVASCRIPT-BASICO-7',2.22222,'133AHMt7xiKgDADSH2rQq60SDX32dMTuM',NULL,'Remoção, Delegação e Animação',7,111)
,('JAVASCRIPT-BASICO-8',2.22222,'1IvJI3JTxMAJN4r38002OCanenbv6O_f7',NULL,'Filtrando uma tabela',8,111)
;
INSERT INTO lessons (code,difficulty,file_id,link,name,skill_sequence,skill_id) VALUES 
('JAVASCRIPT-BASICO-9',2.22222,'11hc_NoOsaipqgICe9tVgOuMKx5Omxh_P',NULL,'AjaxBuscando pacientes com AJAX',9,111)
,('JAVASCRIPT-AVANCADO-01-1',2.0,'1fO1OAw5LTYuDiDDKY_uo3dj91dykwC28',NULL,'Prólogo regras, código e manutenção',1,121)
,('JAVASCRIPT-AVANCADO-01-2',2.0,'1N14Mzo-XyU7CgKcNLO78UsVDVlmG09VL',NULL,'Especificando uma Negociação',2,121)
,('JAVASCRIPT-AVANCADO-01-3',2.0,'1eIeceYPMqdwKZ64VbiHiyd6-2nH7JSoL',NULL,'A ligação entre as ações do usuário e o modelo',3,121)
,('JAVASCRIPT-AVANCADO-01-4',2.0,'1Cy4LfYTjND5dIAtkB-6VmYcl4lVpUZDq',NULL,'Lidar com data é trabalhoso Chame um ajudante!',4,121)
,('JAVASCRIPT-AVANCADO-01-5',2.0,'1s3p5S6atQZwwMINmGeBFwz1e_xDxQUi4',NULL,'Temos o modelo, mas e a view',5,121)
,('JAVASCRIPT-AVANCADO-01-6',2.0,'1rWzV7S0Hfu59L4aUFGL3MEGMiOqTX0t7',NULL,'Generalizando a solução da nossa View',6,121)
,('JAVASCRIPT-AVANCADO-02-1',2.0,'1FxC4kn-EcJxHeOQidIJpqdoyz28EOVtc',NULL,'Como saber quando o modelo mudou',1,131)
,('JAVASCRIPT-AVANCADO-02-2',2.0,'1PahHwTSmHUeAG8qFNqUjj69eVz4rO7kS',NULL,'Existe modelo mentiroso O padrão de projeto Proxy!',2,131)
,('JAVASCRIPT-AVANCADO-02-3',2.0,'1y3PSpaK6dmcJlGzIJFnXqDzSK6eNkTsO',NULL,'E se alguém criasse nossos proxies O Padrão de Projeto Factory',3,131)
;
INSERT INTO lessons (code,difficulty,file_id,link,name,skill_sequence,skill_id) VALUES 
('JAVASCRIPT-AVANCADO-02-4',2.0,'1XOCigoPeDA9s3apDbp7-vYIKChOEPGJT',NULL,'Importando negociações',4,131)
,('JAVASCRIPT-AVANCADO-02-5',2.0,'1MwJHjj6y0A63svZEHsqfIg1JKkR90NUG',NULL,'Combatendo Callback Hell com Promises',5,131)
,('JAVASCRIPT-AVANCADO-02-6',2.0,'1o9ubvoPf347E_wfgV1oaHJ5XjqxjYQRD',NULL,'Considerações finais e exercícios bônus',6,131)
,('TYPESCRIPT-01-1',1.6,'15vLzhcHEyxc6Bz7JRQgTX4SJUwKk8TsS',NULL,'Bem começado, metade feito',1,141)
,('TYPESCRIPT-01-2',1.6,'1PhdWcoT8YL6kamoNQdcUyD7jGx4vo225',NULL,'Benefícios da tipagem estática',2,141)
,('TYPESCRIPT-01-3',1.6,'1XfAByURgi8CU7QU5RX-dO9YHHAqWr283',NULL,'Elaborando uma solução de view',3,141)
,('TYPESCRIPT-01-4',1.6,'1JyAQTsltThybCfU7kHxwuqpXUVji7daI',NULL,'Herança, reaproveitamento de código',4,141)
,('TYPESCRIPT-01-5',1.6,'1zjnB9hJK6ySRv5i2eNBnfylTGaCP0OoO',NULL,'TypeScript definitions',5,141)
,('TYPESCRIPT-02-1',1.6,'1GxaAYd7XdzgH_YuffNR_6XE1JHI2_p82',NULL,'NameSpace e módulos externos',1,151)
,('TYPESCRIPT-02-2',1.6,'1rBTpQ8uNkhnE3nsh5jq2KA2ZzYyhdTMw',NULL,'Lapidando nosso código',2,151)
;
INSERT INTO lessons (code,difficulty,file_id,link,name,skill_sequence,skill_id) VALUES 
('TYPESCRIPT-02-3',1.6,'1wFKAnrjAhm8H92y9uytMNKmUvrpVkdi9',NULL,'O poder dos decorators',3,151)
,('TYPESCRIPT-02-4',1.6,'1QV7KG9163lnoDrJulTR6qv2TFGRnd5Su',NULL,'API externa e interface',4,151)
,('TYPESCRIPT-02-5',1.6,'1e4aJMmJO0DnLWlqShRXXHRVhqCo4mMOl',NULL,'Mais sobre interfaces',5,151)
,('WEBPACK-1',1.33333,'1ESm06s-f4jeO7us2oQKwIlDBwUKWTqs3',NULL,'Introdução',1,161)
,('WEBPACK-2',1.33333,'1U4kBELOxzuHT9j7CwFnIityXjZn5Q7zx',NULL,'Preparando o build de produção',2,161)
,('WEBPACK-3',1.33333,'1gRsokY9T5FAis2EUHxA-1DizC1kzsjzu',NULL,'Webpack Dev Server e configuração',3,161)
,('WEBPACK-4',1.33333,'1EF5gP92Wo5BOBTNdRbKmjBKtVAFTd4co',NULL,'Tratando arquivos CSS como módulos',4,161)
,('WEBPACK-5',1.33333,'1QPezx8RhwHW_NjuqeuMYnmDllCSrcCx-',NULL,'Importando scripts',5,161)
,('WEBPACK-6',1.33333,'1OIvvefDelB5JFJ66d75DciRR13DOuInJ',NULL,'Boas práticas',6,161)
,('ANGULAR-01-1',2.28571,'1rW_c7S89GZiqw2knI9uWGSu0DAyl49wC',NULL,'Bem começado, metade feito',1,171)
;
INSERT INTO lessons (code,difficulty,file_id,link,name,skill_sequence,skill_id) VALUES 
('ANGULAR-01-2',2.28571,'1ItF2IT5-uS2_V6tXiJ8gx3nZ9uYYK2fg',NULL,'Criando o primeiro componente',2,171)
,('ANGULAR-01-3',2.28571,'10hQDUB6TnekexHd9YoCImlUMwgjh3JyA',NULL,'Integração com Web API''s',3,171)
,('ANGULAR-01-4',2.28571,'1nuE1MYeVzjMt9UTyQzdEIfKJxY-mGuNm',NULL,'Single Page Applications e rotas',4,171)
,('ANGULAR-01-5',2.28571,'1MZ_HnJrqvEvT9U_LbDqXJ2OFqz8rJR3k',NULL,'Novo componente, novos conceitos',5,171)
,('ANGULAR-01-6',2.28571,'1neZcuLSLEqjRdkWuCTPB3e9vpM94ci_U',NULL,'Melhorando a experiência do usuário',6,171)
,('ANGULAR-01-7',2.28571,'1N_zDkEUkP_yI4xNXV8bwQ24mfb_W7fU6',NULL,'Lapidando ainda mais nossa aplicação',7,171)
,('ANGULAR-02-1',2.4,'1KM9TsDsIex4LaMclFGXkeBXmxliH-bPX',NULL,'O componente para login',1,181)
,('ANGULAR-02-2',2.4,'1b7G_LGJOUNG5d6A5jrQztj9crMGwLBIg',NULL,'Autenticação e o papel do token',2,181)
,('ANGULAR-02-3',2.4,'1IJ3QZzQC5VJCORgqFiySjDEtMFOur2ho',NULL,'Usuário logado e proteção de rotas',3,181)
,('ANGULAR-02-4',2.4,'1qtd2lWsrP44g6vtrznMTw6rNYNU61_mQ',NULL,'Registro de novos usuários',4,181)
;
INSERT INTO lessons (code,difficulty,file_id,link,name,skill_sequence,skill_id) VALUES 
('ANGULAR-02-5',2.4,'1AgG2HkdTPM6Yb4iFTQbiRJbYu1CoPLjC',NULL,'Rotas filhas e lazy loading',5,181)
,('ANGULAR-03-1',1.5,'1Qz65H9Uiu_0jt01Go7biUajUQXdiYkMU',NULL,'Upload de fotos',1,191)
,('ANGULAR-03-2',1.5,'1YYXSud-sEDIQqZ3kK69fW1KbL3vcAne_',NULL,'Lapidando o upload',2,191)
,('ANGULAR-03-3',1.5,'11HmsWA-Dmc6HjwY0NJxrm6u28mzMLZ9M',NULL,'Detalhes da foto',3,191)
,('ANGULAR-03-4',1.5,'13AzY2F11msWJFpFXjNnSfSQ35G3_9APf',NULL,'Comentando fotos',4,191)
,('ANGULAR-03-5',1.5,'1_DyNkC42fNZqg3avt69nJUPGY1GCcsF4',NULL,'Remoção de fotos e novos componentes',5,191)
,('ANGULAR-03-6',1.5,'1sa8jGrssNjrTZGHKDO4Dr3gcrRMJ8gR6',NULL,'Componente de notificação',6,191)
,('ANGULAR-03-7',1.5,'1sX_k3deDC21sttqWrEN06gGGJyWAfjfm',NULL,'Curtindo fotos',7,191)
,('ANGULAR-03-8',1.5,'1q1VHjfAy0quBK2Y3QH3wlEfUdd35nywu',NULL,'Diferenciando ambientes de deploy',8,191)
,('ANGULAR-04-1',1.25,'1IzgA-aVxQp4zfG3AFqKqlUYTbtEZJw6N',NULL,'Alteração do title',1,201)
;
INSERT INTO lessons (code,difficulty,file_id,link,name,skill_sequence,skill_id) VALUES 
('ANGULAR-04-2',1.25,'1ub_nHXmhdMLJ6AaiuAw9X_QEDKbd0tL1',NULL,'Upload e progresso',2,201)
,('ANGULAR-04-3',1.25,'1-363jCwexRNhY-nvf6dzp_xvx2KcFA2M',NULL,'Indicador de trabalho',3,201)
,('ANGULAR-04-4',1.25,'1Tz_wyXl0b8pZSQQSnffBSM4u2csSBFPk',NULL,'Menu da aplicação',4,201)
,('ANGULAR-04-5',1.25,'1mpC1cwzibMenBZsnb50KBjByl428qvx2',NULL,'Global error handler e log no server side',5,201)
,('ANGULAR-04-6',1.25,'1HVwRQMXIWmDrfo28VwVJeXJO5clo407u',NULL,'Um pouco mais sobre validação',6,201)
,('ANGULAR-04-7',1.25,'1WiazaTrIT1aiqJjWORAz383a8ID-BTqm',NULL,'Um pouco mais sobre navegação e rotas',7,201)
,('ANGULAR-04-0',1.25,'1WNSudvPzlGMPrwYOhXs1GVMGGZnQqpte',NULL,'Angular 4_ Aula 1 - Atividade 1 Projeto da aula anterior _ Alura - Cursos de tecnologia_files',0,201)
,('ANGULAR-JASMINE-1',0.75,'1IzgA-aVxQp4zfG3AFqKqlUYTbtEZJw6N',NULL,'Alteração do title',1,211)
,('ANGULAR-JASMINE-2',0.75,'1ub_nHXmhdMLJ6AaiuAw9X_QEDKbd0tL1',NULL,'Upload e progresso',2,211)
,('ANGULAR-JASMINE-3',0.75,'1-363jCwexRNhY-nvf6dzp_xvx2KcFA2M',NULL,'Indicador de trabalho',3,211)
;
INSERT INTO lessons (code,difficulty,file_id,link,name,skill_sequence,skill_id) VALUES 
('ANGULAR-JASMINE-4',0.75,'1Tz_wyXl0b8pZSQQSnffBSM4u2csSBFPk',NULL,'Menu da aplicação',4,211)
,('ANGULAR-JASMINE-5',0.75,'1mpC1cwzibMenBZsnb50KBjByl428qvx2',NULL,'Global error handler e log no server side',5,211)
,('ANGULAR-JASMINE-6',0.75,'1HVwRQMXIWmDrfo28VwVJeXJO5clo407u',NULL,'Um pouco mais sobre validação',6,211)
,('ANGULAR-JASMINE-7',0.75,'1WiazaTrIT1aiqJjWORAz383a8ID-BTqm',NULL,'Um pouco mais sobre navegação e rotas',7,211)
,('ANGULAR-JASMINE-0',0.75,'1WNSudvPzlGMPrwYOhXs1GVMGGZnQqpte',NULL,'Angular 4_ Aula 1 - Atividade 1 Projeto da aula anterior _ Alura - Cursos de tecnologia_files',0,211)
,('JAVA-01-1',1.0,'14d66Tq4d51qRriD2m2XQPTt7uG6OnXze',NULL,'O que é Java',1,221)
,('JAVA-01-2',1.0,'1A4U7c4qFV8pv9qMEQc2svKj9Lq3BdZbk',NULL,'Instalação e o primeiro programa',2,221)
,('JAVA-01-3',1.0,'1xJScERfflOvwyGqRtrjlQw3ZDBSD1WM2',NULL,'Começando com Eclipse',3,221)
,('JAVA-01-4',1.0,'1ng9VGuIdvbVoTrPAZZyGtP3uU4IsP6xB',NULL,'Tipos e variáveis',4,221)
,('JAVA-01-5',1.0,'1hVC3BEbB6JY8nAL1egPCu8-UamRKF-ck',NULL,'Trabalhando com caracteres',5,221)
;
INSERT INTO lessons (code,difficulty,file_id,link,name,skill_sequence,skill_id) VALUES 
('JAVA-01-6',1.0,'1aobigfgQPYmx-663chiYwcdPXu7IjkNA',NULL,'Praticando condicionais',6,221)
,('JAVA-01-7',1.0,'1gVqmNraAstogbjDtXHdA26rUvpLDljOZ',NULL,'Controlando fluxo com laços',7,221)
,('JAVA-01-0',1.0,'1szeW2XmY0ihxFZRBkaUBIFOy4idnWDI4',NULL,'Java 1_ Aula 1 - Atividade 9 O que aprendemos_ _ Alura - Cursos de tecnologia_files',0,221)
,('JAVA-02-1',1.33333,'1SPV7QAjRfPXZUrvNvZI2Jsuy9zI5Taae',NULL,'O problema do paradigma procedural',1,231)
,('JAVA-02-2',1.33333,'17XqsRzUL2E4liIJOuoyA1rSRCq8i2zBE',NULL,'Introdução à Orientação a Objetos',2,231)
,('JAVA-02-3',1.33333,'1AxIVku2zHuNSg-6tdm6ZlrP2p5BXE94Z',NULL,'Definindo comportamento',3,231)
,('JAVA-02-4',1.33333,'1xX0GWcXjwdHJSTtAsBou8HUeoVx8SI1t',NULL,'Composição de objetos',4,231)
,('JAVA-02-5',1.33333,'1wjIKv7ylWRLeHe9NwNc-SqRlY2MBhXYY',NULL,'Encapsulamento e visibilidade',5,231)
,('JAVA-02-6',1.33333,'1JGFBVzdCZNj2Z6WlWJEQEv-acRdUUa39',NULL,'Construtores e membros estáticos',6,231)
,('JAVA-03-1',2.66667,'1SPV7QAjRfPXZUrvNvZI2Jsuy9zI5Taae',NULL,'O problema do paradigma procedural',1,241)
;
INSERT INTO lessons (code,difficulty,file_id,link,name,skill_sequence,skill_id) VALUES 
('JAVA-03-2',2.66667,'17XqsRzUL2E4liIJOuoyA1rSRCq8i2zBE',NULL,'Introdução à Orientação a Objetos',2,241)
,('JAVA-03-3',2.66667,'1AxIVku2zHuNSg-6tdm6ZlrP2p5BXE94Z',NULL,'Definindo comportamento',3,241)
,('JAVA-03-4',2.66667,'1xX0GWcXjwdHJSTtAsBou8HUeoVx8SI1t',NULL,'Composição de objetos',4,241)
,('JAVA-03-5',2.66667,'1wjIKv7ylWRLeHe9NwNc-SqRlY2MBhXYY',NULL,'Encapsulamento e visibilidade',5,241)
,('JAVA-03-6',2.66667,'1JGFBVzdCZNj2Z6WlWJEQEv-acRdUUa39',NULL,'Construtores e membros estáticos',6,241)
,('JAVA-04-1',2.0,'1mYLBwkClEkP2Q6RmBxSz9HeO_rXinwxv',NULL,'Pilha de execução',1,251)
,('JAVA-04-2',2.0,'1oickLesu59w8TFlKyzwihodutSN-4eTP',NULL,'Tratamento de exceções',2,251)
,('JAVA-04-3',2.0,'1-5jrzdQOVfB0xla0C5zR5mrZMJlGj1hu',NULL,'Lançando exceções',3,251)
,('JAVA-04-4',2.0,'1B7E9t4sWDuXw0ljEFnLLi9IxVzvpAPHU',NULL,'Checked e Unchecked',4,251)
,('JAVA-04-5',2.0,'1bOP4Cqo1BCI1YGvbdJ58WgiSwpHVYjem',NULL,'Aplicando exceções',5,251)
;
INSERT INTO lessons (code,difficulty,file_id,link,name,skill_sequence,skill_id) VALUES 
('JAVA-04-6',2.0,'1khdsd1VkQt_4ZUum-66e1FjuFROxsVfC',NULL,'Finally e try with resources',6,251)
,('JAVA-05-1',2.4,'1WnGaaT8hCbPytT_Xwga3OTGEeX0fJm84',NULL,'Organizando as classes com Pacotes',1,261)
,('JAVA-05-2',2.4,'1T1jkB3wSWGOajbPAYTv4mdvKZAwxUio2',NULL,'Todos os modificadores de acesso',2,261)
,('JAVA-05-3',2.4,'1LwRMFa2N9gxXgf1kmUyvnnUYEyG5KLf2',NULL,'Distribuição do seu código',3,261)
,('JAVA-05-4',2.4,'1ackW3_bXQif7c19fj4sQUcZ5F4Xeeuyl',NULL,'O pacote java.lang',4,261)
,('JAVA-05-5',2.4,'1UcVHgmRj9xAJUGXcPjKoP1BDkvH6UcMw',NULL,'A classe Object',5,261)
,('JAVA-06-1',1.33333,'1S5_e4WWvE0g7jAlopfCxRpq6J3OvFmcz',NULL,'Conhecendo Arrays',1,271)
,('JAVA-06-2',1.33333,'1-kRL_2hYle-2vhumA4Wdp-kdpK0F7Zb1',NULL,'Guardando qualquer referência',2,271)
,('JAVA-06-3',1.33333,'1PaLoNQuQ1j4vKA5oe2YItuFF8F12x6La',NULL,'ArrayList e Generics',3,271)
,('JAVA-06-4',1.33333,'15_6KzV5FcQCPaa_aqkUSLXXWhEZ8gX9O',NULL,'Equals e mais listas',4,271)
;
INSERT INTO lessons (code,difficulty,file_id,link,name,skill_sequence,skill_id) VALUES 
('JAVA-06-5',1.33333,'1ORfFZNh3ZRjOYp2pq-yUpEqqb0ZOYbAE',NULL,'Vector e a interface Collection',5,271)
,('JAVA-06-6',1.33333,'1PIaBIBM1POulExYK_Fb4HRR6eF2crear',NULL,'As classes Wrappers',6,271)
,('JAVA-06-7',1.33333,'1GvtDTxtw7svQu_ACuK69rMc0VzzR_DiV',NULL,'Ordenação de listas',7,271)
,('JAVA-06-8',1.33333,'1CX7G_d1wTmKAxvT1_GWo-GLfqez0xcFA',NULL,'Classes anônimas e Lambdas',8,271)
,('JAVA-06-0',1.33333,'1N9MrLM7OVB8xLzrjDHdzSja7ve5SP0HI',NULL,'guarda',0,271)
,('JAVA8-1',2.0,'1fl9JCZCY0ipEFY0TSDmbYls1K5iBXgs4',NULL,'Default Methods',1,281)
,('JAVA8-2',2.0,'1S60NGBJkI-_j-td6zIHWP1Z_42ONTgl1',NULL,'Que venham os lambdas!',2,281)
,('JAVA8-3',2.0,'19oxngiPJcDlPe7sRvFzzH_ibZhB34O36',NULL,'Código mais sucinto com Method references',3,281)
,('JAVA8-4',2.0,'1IIYoigMs5TOXzGrHOwun8lwMG2QYmgd-',NULL,'Streams trabalhando melhor com coleções',4,281)
,('JAVA8-5',2.0,'1vPpD2Nwci14p85eOsO09VndCEUJ0ZEDp',NULL,'Mais Streams, Collectors e APIs',5,281)
;
INSERT INTO lessons (code,difficulty,file_id,link,name,skill_sequence,skill_id) VALUES 
('JAVA8-6',2.0,'1K4QjXR3p8jtB0UKgofKk0RWB0ZXUo4UY',NULL,'A nova API de datas',6,281)
,('POSTGRESQL-1',1.33333,'1Ubua7vbv5sfXRhpuF_akp76IIXniGftt',NULL,'Primeiros passos com PostgreSQL',1,291)
,('POSTGRESQL-2',1.33333,'1kADjqXL3dwQCa3wJaLrCKeNZcN-hyHAN',NULL,'Executando operações CRUD',2,291)
,('POSTGRESQL-3',1.33333,'13FFi34f_6TLYwBbXJKBVcKSRGyBKc2jD',NULL,'Consultas com filtros',3,291)
,('POSTGRESQL-4',1.33333,'1QtYvbVjIN-KtOkFFfRrdJqPavBscBvAw',NULL,'Trabalhando com relacionamentos',4,291)
,('POSTGRESQL-5',1.33333,'16vmc69p-v7oykRfeTuOB77xXXE3qEB0N',NULL,'Usando CASCADE',5,291)
,('POSTGRESQL-6',1.33333,'1QOX74097UxoMRx7ZcrV1D2Tz45561Nhs',NULL,'Avançando com consultas',6,291)
,('JAVA-JDBC-1',1.71429,'1KMnmM38BIf8WYkkO7OzSUhwG4IoyjUsV',NULL,'Introduc?a?o ao JDBC e o padra?o Factory',1,301)
,('JAVA-JDBC-2',1.71429,'17qf5Mz098hues15GSgZn31xquJDH5Yca',NULL,'Executando comandos SQL no Java',2,301)
,('JAVA-JDBC-3',1.71429,'1qG6JdZeKQeXcuyN3LwPjmSAImlZs9nHQ',NULL,'Evitando SQL Injection',3,301)
;
INSERT INTO lessons (code,difficulty,file_id,link,name,skill_sequence,skill_id) VALUES 
('JAVA-JDBC-4',1.71429,'1tUfD1hKM9nRnGUnlpiyyxHCRLzZuA2pV',NULL,'Controle de transac?a?o',4,301)
,('JAVA-JDBC-5',1.71429,'1j_P_d6bo7CDTAAXxauJ2uitX1m1apMew',NULL,'Escalabilidade com pool de conexo?es',5,301)
,('JAVA-JDBC-6',1.71429,'1CJBoipx0pjYYH6mT3wy_NFPqm3mq-CES',NULL,'Camada de persiste?ncia com DAO',6,301)
,('JAVA-JDBC-7',1.71429,'1kenpzC67ESVFCVDV-fwdCl0Sfnc63s1F',NULL,'Evitando queries N + 1',7,301)
,('JAVA-JPA-1',1.6,'1nYY_-V_7DtpeeHmJwXiX2iEAvCsh5QMa',NULL,'Introdução à Java Persistence API',1,311)
,('JAVA-JPA-2',1.6,'1N75dlPQTZ8G8glPTJyX1KkA8QQclpoWi',NULL,'Usando EntityManager',2,311)
,('JAVA-JPA-3',1.6,'1XRJMZE8Vqupwr51ZslbJPQ5BxGVinP4k',NULL,'Mapeando relacionamentos',3,311)
,('JAVA-JPA-4',1.6,'1r_nUmk_rdpInwk6YbY9fhVbb7cHm-cVv',NULL,'Relacionamento para Muitos',4,311)
,('JAVA-JPA-5',1.6,'1OgNVJnah6jq6z7QsN5fCdKKrEtH5qw7R',NULL,'Pesquisando com JPQL',5,311)
,('MAVEN-1',1.0,'1nRUCux5aW4Gwa2OutL2FBDxE80x43hsM',NULL,'Do zero aos relatórios',1,321)
;
INSERT INTO lessons (code,difficulty,file_id,link,name,skill_sequence,skill_id) VALUES 
('MAVEN-2',1.0,'1NJqn9AAUHS2Tm0yBM-Jv0E_phaw_mwNJ',NULL,'Maven no Eclipse',2,321)
,('MAVEN-3',1.0,'1QL1BSsCUo12gl_s71Pbd4Gzimz0ciyjy',NULL,'Repositório remoto e local',3,321)
,('MAVEN-4',1.0,'1S-AshjChAmNl32WVf1R4SsR2sVtvfTA0',NULL,'Relatórios de qualidade e cobertura',4,321)
,('MAVEN-5',1.0,'1-7uScVwPuP6Vui93-iAdGsu2xOXUxnY3',NULL,'Criando um projeto web',5,321)
,('MAVEN-6',1.0,'1sLYu2lahB8BsCqJYzGVZGlUb_GMkyvXL',NULL,'Projeto web',6,321)
,('SERVLET-01-1',1.25,'1SIEhKKZU-VcQTlCWw0ujkQ968ioTXxHW',NULL,'Fundamentos da Web e a API de Servlets',1,351)
,('SERVLET-01-2',1.25,'1pyzyinubu4GmI99qpVipRj8xcXhE9ZYc',NULL,'Trabalhando com POST e GET',2,351)
,('SERVLET-01-3',1.25,'1Sb_NfJmEgMjswWo_qFVrrUmff9_pfFZI',NULL,'Definindo o nosso modelo',3,351)
,('SERVLET-01-4',1.25,'1L9sZFSn52imctzT5f2Ms8iSJpeUPgt6U',NULL,'Páginas dinâmicas com JSP',4,351)
,('SERVLET-01-5',1.25,'1x7uA-JwLQxoCETwOsRrPeb-aUJYwZ3S1',NULL,'JSTL e Expression Language',5,351)
;
INSERT INTO lessons (code,difficulty,file_id,link,name,skill_sequence,skill_id) VALUES 
('SERVLET-01-6',1.25,'1yrqF-4Eg-IzAuFTkyVhzm8J8o_IxhW0I',NULL,'Redirecionando o fluxo',6,351)
,('SERVLET-01-7',1.25,'1K1eBQHNoJSvL8hZxGIQhsDYAQhieuQy2',NULL,'Completando o CRUD',7,351)
,('SERVLET-01-8',1.25,'1g7nA54ePSaaFx7mwsDm79VS2_cOBuZct',NULL,'Deploy da aplicação',8,351)
,('SERVLET-02-1',2.0,'1xxxpNCZlz5FpYUbtP8L5A-Do91xp1dMA',NULL,'Criando o controlador',1,351)
,('SERVLET-02-2',2.0,'1szoKnLlRJO2oUkkaqccglvhAJiURsiCT',NULL,'O padrão MVC',2,351)
,('SERVLET-02-3',2.0,'1R5S9r1-iCW87EL-qfbiOz3Gj62w7N8oN',NULL,'Formulário de login',3,351)
,('SERVLET-02-4',2.0,'1QYo0W-4Zw9ph9oVo0Fn3OCvusligS7rb',NULL,'HttpSession',4,351)
,('SERVLET-02-5',2.0,'1v1l2JmeWWdwhXOEIO8VM1s_GLz1NHxhy',NULL,'Aplicando filtros',5,351)
,('SERVLET-02-6',2.0,'1XitGgCCCkSmZAOkR7X6Pwt60BZHWsu4h',NULL,'Introdução ao Web Services',6,351)
,('SERVLET-02-7',2.0,'1OEJHEusig22jJwFUacvOvE4HXlOGscty',NULL,'Deploy no Jetty',7,351)
;
INSERT INTO lessons (code,difficulty,file_id,link,name,skill_sequence,skill_id) VALUES 
('SPRING-BOOT-01-1',1.33333,'1nj1YT9FyPsMHWuhm52LSnOov4Cp1beC4',NULL,'Introdução ao Spring Boot',1,351)
,('SPRING-BOOT-01-2',1.33333,'1EjmexVvdeY4uJDJrNgVac4PHuTHmargd',NULL,'Publicando Endpoints',2,351)
,('SPRING-BOOT-01-3',1.33333,'1ycn7XTPFHXXk9hhOr55gpfgFkt8ZKQrt',NULL,'Usando Spring Data',3,351)
,('SPRING-BOOT-01-4',1.33333,'1lzUlPhBx3aEPz9UjZ2g4oCXtYPA4odcV',NULL,'Trabalhando com POST',4,351)
,('SPRING-BOOT-01-5',1.33333,'1_Or1niG3BZbV11HLsmJQ53pfYjC3hqkU',NULL,'Validação com Bean Validation',5,351)
,('SPRING-BOOT-01-6',1.33333,'1nRGsyay6cA6dv4JHmKl_HyI7LPGFyQZ6',NULL,' Métodos PUT, DELETE e tratamento de erro',6,351)
;

