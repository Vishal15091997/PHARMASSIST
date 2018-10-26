-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 30, 2018 at 01:49 PM
-- Server version: 10.1.22-MariaDB
-- PHP Version: 7.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `medicine`
--

-- --------------------------------------------------------

--
-- Table structure for table `information`
--

CREATE TABLE `information` (
  `ID` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Price` float(9,2) NOT NULL,
  `Quantity` int(100) NOT NULL,
  `Supplier` varchar(100) NOT NULL,
  `Stockin` int(11) NOT NULL,
  `Stockout` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `information`
--

INSERT INTO `information` (`ID`, `Name`, `Price`, `Quantity`, `Supplier`, `Stockin`, `Stockout`) VALUES
(1, 'Aspirin', 8.00, 80, 'abc@gmail.com', 0, 0),
(2, 'Brilinta', 700.00, 90, 'def@gmail.com', 0, 0),
(3, 'Diclofenac Sodium 50 mg Tab', 16.50, 70, 'hij@gmail.com', 0, 0),
(4, 'Fluconazole 150 mg Tabs', 33.75, 100, 'klm@gmail.com', 0, 0),
(5, 'Gabapentin 300mg', 92.00, 85, 'nop@gmail.com', 0, 0),
(6, 'Havrix-720', 1200.00, 20, 'pld@gmail.com', 0, 0),
(7, 'Keflex 500 mg', 144.00, 90, 'ghj@gmail.com', 0, 0),
(8, 'Aminophylline 225 mg', 44.80, 100, 'bhj@gmail.com', 0, 0),
(9, 'Bacampicillin 200 mg', 78.90, 200, 'bhj@gmail.com', 0, 0),
(10, 'Verapamil 40 mg', 67.90, 150, 'bxd@gmail.com', 0, 0),
(11, 'Cefixime', 1167.90, 300, 'awe@gmail.com', 0, 0),
(12, 'Chlorambucil\r\n', 560.78, 200, 'iok@gmail.com', 0, 0),
(13, 'Daunorubicin', 230.60, 180, 'qwe@gmail.com', 0, 0),
(14, 'Enoxaparin', 345.67, 110, 'okl@gmail.com', 0, 0),
(15, 'Famotidine', 67.90, 112, 'opl@gmail.com', 0, 0),
(16, 'Fentanyl', 587.90, 90, 'rty@gmail.com', 0, 0),
(17, 'Filgrastim', 234.67, 120, 'yui@gmail.com', 0, 0),
(18, 'Ifosfamide', 678.45, 230, 'iop@gmail.com', 0, 0),
(19, 'Imatinib', 333.67, 60, 'jkl@gmail.com', 0, 0),
(20, 'Leflunomide', 444.00, 110, 'iop@gmail.com', 0, 0),
(21, 'Lorazepam', 71.66, 30, 'cft@gmail.com', 0, 0),
(22, 'Mefloquine', 69.99, 70, 'vbn@gmail.com', 0, 0),
(23, 'Mesna', 90.88, 90, 'tdf@gmail.com', 0, 0),
(24, 'Misoprostol', 345.99, 145, 'scv@gmail.com', 0, 0),
(25, 'Olanzapine', 45.33, 70, 'efg@gmail.com', 0, 0),
(26, 'Oxaliplatin', 234.55, 340, 'xct@gmail.com', 0, 0),
(27, 'Pantoprazole', 156.77, 130, 'wtd@gmail.com', 0, 0),
(28, 'Permethrin', 76.44, 20, 'gse@gmail.com', 0, 0),
(29, 'Piperazine', 95.33, 200, 'yiu@gmail.com', 0, 0),
(30, 'Propofol', 275.66, 235, 'jkq@gmail.com', 0, 0),
(31, 'Sevoflurane', 312.11, 235, 'qbn@gmail.com', 0, 0),
(32, 'Tramadol', 545.55, 60, 'cvd@gmail.com', 0, 0),
(33, 'Vecuronium', 86.66, 55, 'wzs@gmail.com', 0, 0),
(34, 'Busulphan', 967.66, 300, 'bsp@gmail.com', 0, 0),
(35, 'Piperazine', 456.44, 95, 'okl@gmail.com', 0, 0),
(36, 'Mefloquine', 245.67, 60, 'fvy@gmail.com', 0, 0),
(37, 'Bleomycin', 736.44, 85, 'okp@gmail.com', 0, 0),
(38, 'Danazol ', 59.00, 60, 'wni@gmail.com', 0, 0),
(39, 'Clopidogrel', 234.77, 180, 'enj@gmail.com', 0, 0),
(40, 'Nifedipine', 126.33, 65, 'bwt@gmail.com', 0, 0),
(41, 'Urokinase', 941.22, 500, 'pgl@gmail.com', 0, 0),
(42, 'Lignocaine', 72.00, 135, 'pdn@gmail.com', 0, 0),
(43, 'Mannitol', 453.33, 160, 'smk@gmail.com', 0, 0),
(44, 'Omeprazole', 234.77, 70, 'pwk@gmail.com', 0, 0),
(45, 'Ondansetron', 234.55, 120, 'elp@gmail.com', 0, 0),
(46, 'Ispaghula', 78.66, 40, 'vdl@gmail.com', 0, 0),
(47, 'Prednisolone ', 93.55, 265, 'wxl@gmail.com', 0, 0),
(48, 'Metformin', 493.88, 95, 'vrl@gmail.com', 0, 0),
(49, 'Glucagon', 876.33, 150, 'bfl@gmail.com', 0, 0),
(50, 'Oxytocin', 345.22, 20, 'slm@gmail.com', 0, 0),
(51, 'Aripiprazole', 456.66, 60, 'bhj@gmail.com', 0, 0),
(52, 'Adalimumab', 700.00, 90, 'khj@gmail.com', 0, 0),
(53, 'Esomeprazole', 16.50, 70, 'wbj@gmail.com', 0, 0),
(54, 'Rosuvastatin', 33.75, 100, 'mso@gmail.com', 0, 0),
(55, 'Etanercept', 92.00, 85, 'olx@gmail.com', 0, 0),
(56, 'Infliximab	', 864.99, 90, 'olp@gmail.com', 0, 0),
(57, 'Filgrastim', 89.99, 45, 'wer@gmail.com', 0, 0),
(58, 'Glatiramer', 32.55, 280, 'wol@gmail.com', 0, 0),
(59, 'Rituximab', 23.44, 145, 'plk@gmail.com', 0, 0),
(60, 'Sitagliptin', 21.33, 50, 'hbg@gmail.com', 0, 0),
(61, 'Duloxetine', 880.22, 450, 'qal@gmail.com', 0, 0),
(62, 'Bevacizumab', 90.55, 50, 'okl@gmail.com', 0, 0),
(63, 'Pregabalin', 123.33, 340, 'wag@gmail.com', 0, 0),
(64, 'Oxycodone', 756.44, 70, 'thd@gmail.com', 0, 0),
(65, 'Celecoxib', 129.40, 30, 'prf@gmail.com', 0, 0),
(66, 'Epoetin alfa', 209.77, 100, 'wlm@gmail.com', 0, 0),
(67, 'Valsartan', 54.66, 80, 'sxl@gmail.com', 0, 0),
(68, 'Imatinib', 765.55, 420, 'nhm@gmail.com', 0, 0),
(69, 'Trastuzumab', 932.22, 20, 'plm@gmail.com', 0, 0),
(70, 'Lisdexamfetamine', 65.66, 90, 'ofl@gmail.com', 0, 0),
(71, 'Ranibizumab', 632.55, 50, 'nhm@gmail.com', 0, 0),
(72, 'Ezetimibe', 10.33, 500, 'plm@gmail.com', 0, 0),
(73, 'Memantine', 76.55, 70, 'gbn@gmail.com', 0, 0),
(74, 'Rivaroxaban', 76.55, 130, 'vcy@gmail.com', 0, 0),
(75, 'Buprenorphine', 433.44, 810, 'ksl@gmail.com', 0, 0),
(76, 'Sildenafil', 1459.99, 320, 'ldm@gmail.com', 0, 0),
(77, 'Quetiapine', 43.44, 30, 'lsm@gmail.com', 0, 0),
(78, 'Telaprevir', 78.66, 90, 'enb@gmail.com', 0, 0),
(79, 'Enoxaparin', 40.55, 90, 'evb@gmail.com', 0, 0),
(80, 'Methylphenidate', 122.33, 20, 'sml@gmail.com', 0, 0),
(81, 'Salbutamol', 34.44, 60, 'wsq@gmail.com', 0, 0),
(82, 'Pemetrexed', 17.77, 450, 'xlm@gmail.com', 0, 0),
(83, 'Liraglutide', 82.11, 10, 'oez@gmail.com', 0, 0),
(84, 'Palivizumab', 87.22, 60, 'wql@gmail.com', 0, 0),
(85, 'Tadalafil', 90.55, 400, 'bnz@gmail.com', 0, 0),
(86, 'Mometasone', 548.33, 560, 'pdm@gmail.com', 0, 0),
(87, 'Darunavir', 345.66, 50, 'trl@gmail.com', 0, 0),
(88, 'Raltegravir', 44.55, 210, 'srl@gmail.com', 0, 0),
(89, 'Solifenacin', 57.44, 515, 'asl@gmail.com', 0, 0),
(90, 'Filgrastim', 40.00, 45, 'dml@gmail.com', 0, 0),
(91, 'Lidocaine', 8.00, 80, 'uhl@gmail.com', 0, 0),
(92, 'Olmesartan', 700.00, 90, 'elm@gmail.com', 0, 0),
(93, 'Atorvastatin', 16.50, 600, 'cvl@gmail.com', 0, 0),
(94, 'Zostavax', 33.75, 520, 'tgv@gmail.com', 0, 0),
(95, 'Valproate', 92.00, 85, 'plw@gmail.com', 0, 0),
(96, 'Dabigatran', 80.44, 40, 'eml@gmail.com', 0, 0),
(97, 'Raloxifene', 34.99, 55, 'bnm@gmail.com', 0, 0),
(98, 'Capecitabine', 95.66, 65, 'plm@gmail.com', 0, 0),
(99, 'Everolimus', 40.33, 35, 'fgh@gmail.com', 0, 0),
(100, 'Pneumococcal conjugate vaccine', 89.00, 90, 'uhn@gmail.com', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `User_Name` text NOT NULL,
  `Password` text NOT NULL,
  `Email` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `User_Name`, `Password`, `Email`) VALUES
(1, 'Vishal', '12345', 'abc@gmail.com'),
(2, 'Piyush', '67890', 'xyz@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `information`
--
ALTER TABLE `information`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `information`
--
ALTER TABLE `information`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
