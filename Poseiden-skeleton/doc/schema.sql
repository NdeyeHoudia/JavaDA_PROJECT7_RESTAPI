-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 26 avr. 2024 à 14:22
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `demo`
--

-- --------------------------------------------------------

--
-- Structure de la table `bidlist`
--

CREATE TABLE `bidlist` (
  `bid_list_id` int(11) NOT NULL,
  `account` varchar(255) DEFAULT NULL,
  `ask` double DEFAULT NULL,
  `ask_quantity` double DEFAULT NULL,
  `benchmark` varchar(255) DEFAULT NULL,
  `bid` double DEFAULT NULL,
  `bid_list_date` datetime(6) DEFAULT NULL,
  `bid_quantity` double DEFAULT NULL,
  `book` varchar(255) DEFAULT NULL,
  `commentary` varchar(255) DEFAULT NULL,
  `creation_date` datetime(6) DEFAULT NULL,
  `creation_name` varchar(255) DEFAULT NULL,
  `deal_name` varchar(255) DEFAULT NULL,
  `deal_type` varchar(255) DEFAULT NULL,
  `revision_date` datetime(6) DEFAULT NULL,
  `revision_name` varchar(255) DEFAULT NULL,
  `security` varchar(255) DEFAULT NULL,
  `side` varchar(255) DEFAULT NULL,
  `source_list_id` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `trader` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `bidlist`
--

INSERT INTO `bidlist` (`bid_list_id`, `account`, `ask`, `ask_quantity`, `benchmark`, `bid`, `bid_list_date`, `bid_quantity`, `book`, `commentary`, `creation_date`, `creation_name`, `deal_name`, `deal_type`, `revision_date`, `revision_name`, `security`, `side`, `source_list_id`, `status`, `trader`, `type`) VALUES
(1, '100', NULL, NULL, NULL, NULL, NULL, 10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Sac'),
(8, '100', NULL, NULL, NULL, NULL, NULL, 1222, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'test MODIFIE'),
(11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(12, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(13, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `curvepoint`
--

CREATE TABLE `curvepoint` (
  `id` int(11) NOT NULL,
  `as_of_date` datetime(6) DEFAULT NULL,
  `creation_date` datetime(6) DEFAULT NULL,
  `curve_id` int(11) DEFAULT NULL,
  `term` double DEFAULT NULL,
  `value` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `curvepoint`
--

INSERT INTO `curvepoint` (`id`, `as_of_date`, `creation_date`, `curve_id`, `term`, `value`) VALUES
(1, NULL, NULL, NULL, 45, 23),
(6, NULL, NULL, NULL, 100, 100);

-- --------------------------------------------------------

--
-- Structure de la table `rating`
--

CREATE TABLE `rating` (
  `id` int(11) NOT NULL,
  `fitch_rating` varchar(255) DEFAULT NULL,
  `moodys_rating` varchar(255) DEFAULT NULL,
  `order_number` int(11) DEFAULT NULL,
  `sandprating` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `rating`
--

INSERT INTO `rating` (`id`, `fitch_rating`, `moodys_rating`, `order_number`, `sandprating`) VALUES
(1, 'test', 'test', 1, 'logiciel');

-- --------------------------------------------------------

--
-- Structure de la table `rulename`
--

CREATE TABLE `rulename` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `json` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sql_part` varchar(255) DEFAULT NULL,
  `sql_str` varchar(255) DEFAULT NULL,
  `template` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `rulename`
--

INSERT INTO `rulename` (`id`, `description`, `json`, `name`, `sql_part`, `sql_str`, `template`) VALUES
(1, 'tester des virus ', 'test', 'logiciel', 'test', 'SQL MODIFIE', 'test'),
(3, 'test', 'test', 'test', 'test', 'test', 'test'),
(7, 'Virement loyer', 'test', 'test', 'test', 'test', 'test');

-- --------------------------------------------------------

--
-- Structure de la table `trade`
--

CREATE TABLE `trade` (
  `trade_id` int(11) NOT NULL,
  `account` varchar(255) DEFAULT NULL,
  `benchmark` varchar(255) DEFAULT NULL,
  `book` varchar(255) DEFAULT NULL,
  `buy_price` double DEFAULT NULL,
  `buy_quantity` double DEFAULT NULL,
  `creation_date` datetime(6) DEFAULT NULL,
  `creation_name` varchar(255) DEFAULT NULL,
  `deal_name` varchar(255) DEFAULT NULL,
  `deal_type` varchar(255) DEFAULT NULL,
  `revision_date` datetime(6) DEFAULT NULL,
  `revision_name` varchar(255) DEFAULT NULL,
  `security` varchar(255) DEFAULT NULL,
  `sell_price` double DEFAULT NULL,
  `sell_quantity` double DEFAULT NULL,
  `side` varchar(255) DEFAULT NULL,
  `source_list_id` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `trade_date` datetime(6) DEFAULT NULL,
  `trader` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `trade`
--

INSERT INTO `trade` (`trade_id`, `account`, `benchmark`, `book`, `buy_price`, `buy_quantity`, `creation_date`, `creation_name`, `deal_name`, `deal_type`, `revision_date`, `revision_name`, `security`, `sell_price`, `sell_quantity`, `side`, `source_list_id`, `status`, `trade_date`, `trader`, `type`) VALUES
(1, 'ABB', NULL, NULL, NULL, 10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'livret A'),
(3, 'AAAC', NULL, NULL, NULL, 20, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'livret A'),
(6, 'test', NULL, NULL, NULL, 100, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'test');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `fullname`, `password`, `role`, `username`) VALUES
(1, 'Houdia', '$2a$10$D9i3FcsLnAPXPxMr4IueueevaM1MxXK3OuzNVo96/pwPvWQKkZemS', 'USER', 'ndeyea'),
(4, 'User', '$2b$12$nsBZoAW/fcq2IoFu/9QM1OCnhL/wtrHk0SMya9UsRK5T0lAuno95y', 'USER', 'user'),
(9, 'ndeye', '$2a$10$hqXL09JIheJ.0kgsfymQMO8sYulbIVfX66v10kJBPtMPdFzkk6Mpm', 'USER', 'ndeye'),
(358, 'Administrator', '$2a$10$GdzDlPIjv6KEEFZMbvtHw.rn70kZsr8dt8PuWY5YwoZ5Tu8RLXOOe', 'ADMIN', 'Admin'),
(402, 'test', '$2a$10$R0CWKniLHlqpja6HeQ.oGOtDrae2gqCa.81cocr90A81rcYL3b3UO', 'USER', 'modouSV12@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `users_seq`
--

CREATE TABLE `users_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `users_seq`
--

INSERT INTO `users_seq` (`next_val`) VALUES
(501);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `bidlist`
--
ALTER TABLE `bidlist`
  ADD PRIMARY KEY (`bid_list_id`);

--
-- Index pour la table `curvepoint`
--
ALTER TABLE `curvepoint`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `rating`
--
ALTER TABLE `rating`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `rulename`
--
ALTER TABLE `rulename`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `trade`
--
ALTER TABLE `trade`
  ADD PRIMARY KEY (`trade_id`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `bidlist`
--
ALTER TABLE `bidlist`
  MODIFY `bid_list_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pour la table `curvepoint`
--
ALTER TABLE `curvepoint`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `rating`
--
ALTER TABLE `rating`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `rulename`
--
ALTER TABLE `rulename`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `trade`
--
ALTER TABLE `trade`
  MODIFY `trade_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=403;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
