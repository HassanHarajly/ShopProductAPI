/****** Object:  Database [SHOP_INFORMATION]    Script Date: 4/14/2021 9:14:12 PM ******/
use SHOP_INFORMATION
GO
ALTER DATABASE [SHOP_INFORMATION] SET COMPATIBILITY_LEVEL = 150
GO
ALTER DATABASE [SHOP_INFORMATION] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [SHOP_INFORMATION] SET ANSI_NULLS OFF
GO
ALTER DATABASE [SHOP_INFORMATION] SET ANSI_PADDING OFF
GO
ALTER DATABASE [SHOP_INFORMATION] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [SHOP_INFORMATION] SET ARITHABORT OFF
GO
ALTER DATABASE [SHOP_INFORMATION] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [SHOP_INFORMATION] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [SHOP_INFORMATION] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [SHOP_INFORMATION] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [SHOP_INFORMATION] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [SHOP_INFORMATION] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [SHOP_INFORMATION] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [SHOP_INFORMATION] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [SHOP_INFORMATION] SET ALLOW_SNAPSHOT_ISOLATION ON
GO
ALTER DATABASE [SHOP_INFORMATION] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [SHOP_INFORMATION] SET READ_COMMITTED_SNAPSHOT ON
GO
ALTER DATABASE [SHOP_INFORMATION] SET  MULTI_USER
GO
ALTER DATABASE [SHOP_INFORMATION] SET QUERY_STORE = ON
GO
ALTER DATABASE [SHOP_INFORMATION] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 7), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 10, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200)
GO
/*** The scripts of database scoped configurations in Azure should be executed inside the target database connection. ***/
GO
-- ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 8;
GO
/****** Object:  FullTextCatalog [products catalog]    Script Date: 4/14/2021 9:14:12 PM ******/
CREATE FULLTEXT CATALOG [products catalog] WITH ACCENT_SENSITIVITY = ON
GO
/****** Object:  Table [dbo].[products]    Script Date: 4/14/2021 9:14:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[products](
                                 [id] [bigint] IDENTITY(1,1) NOT NULL,
                                 [shop_id] [int] NOT NULL,
                                 [product_name] [varchar](400) NULL,
                                 [product_quantity] [int] NOT NULL,
                                 [product_barcode] [varchar](15) NOT NULL,
                                 [product_price] [float] NOT NULL,
                                 [latitude] [float] NOT NULL,
                                 [longitude] [float] NOT NULL,
                                 [image] [varchar](max) NULL,
                                 PRIMARY KEY CLUSTERED
                                     (
                                      [id] ASC
                                         )WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[shops]    Script Date: 4/14/2021 9:14:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[shops](
                              [id] [int] IDENTITY(1,1) NOT NULL,
                              [shop_name] [varchar](100) NOT NULL,
                              [SHOP_LATITUDE] [float] NOT NULL,
                              [SHOP_LONGITUDE] [float] NOT NULL,
                              PRIMARY KEY CLUSTERED
                                  (
                                   [id] ASC
                                      )WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER DATABASE [SHOP_INFORMATION] SET  READ_WRITE
GO