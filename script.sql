CREATE TABLE [products](
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
CREATE TABLE [shops](
                        [id] [int] IDENTITY(1,1) NOT NULL,
                        [shop_name] [varchar](100) NOT NULL,
                        [shop_street_address] [varchar](100) NOT NULL,
                        [shop_zip] [varchar](10) NOT NULL,
                        [shop_state] [varchar](30) NOT NULL,
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
