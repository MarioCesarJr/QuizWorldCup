CREATE DATABASE  IF NOT EXISTS `quiz` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `quiz`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: quiz
-- ------------------------------------------------------
-- Server version	5.6.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `jogadores`
--

DROP TABLE IF EXISTS `jogadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jogadores` (
  `idJogadores` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `pontuacao` int(11) DEFAULT NULL,
  PRIMARY KEY (`idJogadores`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jogadores`
--

LOCK TABLES `jogadores` WRITE;
/*!40000 ALTER TABLE `jogadores` DISABLE KEYS */;
INSERT INTO `jogadores` VALUES (1,'João',3),(2,'José',2),(3,'arnaldo',2),(4,'',2),(5,'',2),(6,'',0),(7,'Zé',2),(8,'carlos',2),(9,'Tayrone',2),(10,'Alex',20),(11,'',0),(12,'',10),(13,'',0),(14,'bebeto',60),(15,'',0),(16,'teste',90),(17,'',0),(18,'',80),(19,'',0),(20,'teste5656',100),(21,'',0),(22,'tesds443',60),(23,'',0),(24,'fer',10),(25,'',0),(26,'Carlos',100),(27,'',0),(28,'',0),(29,'ander',80),(30,'',90),(31,'fulano',90),(32,'',20),(33,'Teste5',90);
/*!40000 ALTER TABLE `jogadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perguntas`
--

DROP TABLE IF EXISTS `perguntas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perguntas` (
  `idPerguntas` int(11) NOT NULL AUTO_INCREMENT,
  `questao` text NOT NULL,
  `alter_a` text NOT NULL,
  `alter_b` text NOT NULL,
  `alter_c` text NOT NULL,
  `alter_d` text NOT NULL,
  `resp_certa` text NOT NULL,
  `nivel` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPerguntas`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perguntas`
--

LOCK TABLES `perguntas` WRITE;
/*!40000 ALTER TABLE `perguntas` DISABLE KEYS */;
INSERT INTO `perguntas` VALUES (1,'A maior goleada em uma eliminatória da Copa foi em 2001 no jogo entre Austrália e Samoa','a) 31 a 0','b) 22 a 0','c) 15 a 1','d) 45 a 0','a) 31 a 0',1),(2,'Qual é o nome do mascote da copa do mundo de 2014?','a) Zico','b) Zeca','c) Zizu','d) Fuleco','d) Fuleco',1),(3,'Qual era o mascote da copa de 2010 na Africa?','a) Tatu','b) Gorila','c) Zebra','d) Leopardo','d) Leopardo',1),(4,'Qual foi o jogador que mais participou de copas?','a) Pelé','b) Ronaldinho Gaúcho','c) Romário','d) Tafarel','a) Pelé',1),(5,'Quando ocorreu a primeira copa do mundo?','a) 1928','b) 1930','c) 1934','d) 1912','b) 1930',1),(6,'Qual o meio de transporte que a seleção brasileira usou para chegar no Uruguai na copa de 1930?','a) Carro','b) Navio','c) Ônibus','d) Avião','b) Navio',2),(7,'Qual foi o continente que mais sediou uma copa do mundo?','a) América do Sul','b) Europa','c) Africa','d) Asia','b) Europa',2),(8,'Qual foi o jogador que mais participou de finais de copa do mundo?','a) Garrincha','b) Maradona','c) Cafú','d) Pelé','c) Cafú',2),(9,'Qual foi o ano e  copa que o Brasil ganhou o primeiro título?','a) 1930 (Uruguai)','b) 1958 (Suécia)','c) 1962 (Chile)','d) 1974 (Alemanha) ','b) 1958 (Suécia)',2),(10,'A partir de qual copa começou a ser usado os cartões vermelho e amarelo?','a) 1962 (Chile)','b) 1982 (Espanha)','c) 1934 (Itália)','d) 1970 (México)','d) 1970 (México)',2),(11,'Quantos Jogadore saíram contundidos nos 5 primeiros dias da copa de 1962 no Chile?','a) 15','b) 22','c) 52','d) 50','d) 50',3),(12,'De quantos gols foi a maior goleada que já aconteceu na história da copa do mundo? ','a) 8','b) 22','c) 10','d) 5','c) 10',3),(13,'Na base da Taça da copa existe espaço para gravar o nome das seleções campeãs somente até o ano de...','a) 2038','b) 2022','c) 2048','d) 2042','a) 2038',3),(14,'Qual foi o maior artilheiro de todas as copas do mundo?','a) Pelé','b) Maradona','c) Garrincha','d) Ronaldo Fenômeno','d) Ronaldo Fenômeno',1),(15,'Qual foi o jogador mais jovem a marcar um gol em uma copa do mundo?','a) Neymar','b) Garrincha','c) Oliver Kan','d) Pelé','d) Pelé',1),(16,'Qual foi a seleção que não levou gol na copa de 2006 na Alemanha?','a) Alemanha','b) Suiça','c) Brasil','d) Argentina','b) Suiça',1),(18,'A primeira Copa do Mundo de Futebol a ter um mascote foi a de 1966, na Inglaterra. Era um leãozinho chamado... ','a) Tobby','b) Charlie','c) Willie','d) Willians','c) Willie',1),(20,'Que animal invadiu o campo na copa de 1962 realizada no Chile?','a) Cachorro','b) Gato','c) Porco','d) Papagaio','a) Cachorro',1),(21,'Na copa da alemanha em 74 a seleção da Holanda ganhou um apelido que era...','a) Laranja Holandesa','b) Laranja Mecânica','c) Laranja Infernal','d) Azurra','b) Laranja Mecânica',1),(22,'O jovem irlandês Norman Whiteside foi o jogador mais jovem a participar de uma copa do mundo,ele disputou a copa com apenas...','a) 17 anos','b) 15 anos','c) 13 anos','d) 11 anos','a) 17 anos',2),(23,'Na final da copa de 1990,o árbitro esqueceu de olhar o tempo no relógio.Quanto durou o primeiro tempo do jogo?','a) 59 minutos','b) 53 minutos','c) 61 minutos','d) 51 minutos','b) 53 minutos',2),(24,'Em quanto tempo ocorreu o gol mais rápido da copa do mundo?','a) 5 segundos','b) 11 segundos','c) 30 segundos','d) 22 segundos','b) 11 segundos',2),(25,'Na copa de 1994 entre Bulgária e México o defensor mexicano Marcelino Bernal,ao tentar salvar a bola exagerou na força e acabou quebrando...','a) a  perna','b)  a mão','c) a trave','d) o joelho','c) a trave',2),(26,'Na copa de 1938 na França,o jogador brasileiro Leônidas marcou um gol curioso,De que forma ele marcou esse gol?','a) Descalço','b) De bicicleta','c) De letra','d) De carrinho','a) Descalço',2),(27,'Na copa de 1934,outro fato curioso.O jogador da seleção suiça Leopold Kielholz jogou usando...','a) Luvas','b) Tenis','c) Óculos','d) Blusa','c) Óculos',2),(28,'Na copa do Uruguai,realizada em 1930,um jogador chamou a atenção de todos.O uruguaio Hector Castro não tinha um membro.Qual era o membro que ele não possuía?','a) Braço','b) Perna','c) Mão','d) Orelha','c) Mão',3),(29,'Até a Copa do Mundo de 2006,já foram disputadas quantas partidas?','a) 586 partidas','b) 789 partidas','c) 809 partidas','d) 708 partidas','d) 708 partidas',3),(30,'A maior média de gols em uma Copa foi a de 1954 (Suiça). Quantos gols foram marcados em média? ','a) 5,4 por partida','b) 3,2 por partida','c) 4,2 por partida','d) 5,3 por partida','a) 5,4 por partida',3),(31,'Quantas seleções participaram da primeira Copa do Mundo?','a) 14','b) 13','c) 18','d) 22','b) 13',3),(32,'Qual foi a seleção que ganhou a primeira Copa do Mundo?','a) Uruguai','b) Brasil','c) Espanha','d) Argentina','a) Uruguai',3),(33,'O maior público em um jogo de Copa do Mundo foi justamente na partida entre Brasil e Uruguai Na final de 1950.No total,compareceram quantas pessoas?','a) 199.854 pessoas','b) 240.984 pessoas','c) 322.225 pessoas','d) 188.987 pessoas','a) 199.854 pessoas',3),(34,'Quem foi o primeiro jogador a perder um pênalti em um mundial?','a) Guilherme Stáldi','b) Héctor Scaronni','c) Carlos Vidal','d) Hernandes Vidal','d) Hernandes Vidal',3),(35,'Qual foi os 2 jogadores da seleção brasileira que ficaram no banco durante a copa de 1990?','a) Romário e Dunga','b) Bebeto e Tita','c) Romário e Bebeto','d) Cilas e Branco','c) Romário e Bebeto',3);
/*!40000 ALTER TABLE `perguntas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perguntas_jogadores`
--

DROP TABLE IF EXISTS `perguntas_jogadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perguntas_jogadores` (
  `cod_perguntas` int(11) DEFAULT NULL,
  `cod_jogadores` int(11) DEFAULT NULL,
  KEY `fk_jogadores_idx` (`cod_jogadores`),
  KEY `fk_perguntas_idx` (`cod_perguntas`),
  CONSTRAINT `fk_jogadores` FOREIGN KEY (`cod_jogadores`) REFERENCES `jogadores` (`idJogadores`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_perguntas` FOREIGN KEY (`cod_perguntas`) REFERENCES `perguntas` (`idPerguntas`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perguntas_jogadores`
--

LOCK TABLES `perguntas_jogadores` WRITE;
/*!40000 ALTER TABLE `perguntas_jogadores` DISABLE KEYS */;
/*!40000 ALTER TABLE `perguntas_jogadores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-05-17 14:20:43
