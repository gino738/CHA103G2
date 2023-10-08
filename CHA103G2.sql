
-- ALTER TABLE EMP DROP FOREIGN KEY EMP_DEPTNO_FK;
-- ALTER TABLE EMP DROP FOREIGN KEY EMP_MGR_FK;
--  
-- ALTER TABLE ORD DROP FOREIGN KEY ORD_CUSTID_FK ;
--    
-- ALTER TABLE ITEM DROP FOREIGN KEY ITEM_ORDID_FK;
-- ALTER TABLE ITEM DROP FOREIGN KEY ITEM_PRODD_FK;
-- =====================================[訂房管理]===================================  
DROP TABLE IF EXISTS room_order;                      -- 訂房訂單資料表
CREATE TABLE room_order (
  room_order_no int NOT NULL AUTO_INCREMENT ,         -- 訂單編號
  room_order_date datetime NOT NULL,                  -- 訂單日期
  checkin_date datetime NOT NULL,                     -- 住房日期
  checkout_date datetime NOT NULL,                    -- 退房日期
  room_type_no int NOT NULL,                          -- 房型編號(FK)
  mem_no int NOT NULL,                                -- 會員編號(FK)
  room_amount int NOT NULL,                           -- 間數
  price int NOT NULL,                                 -- 價錢
  payment_method Tinyint NOT NULL,                    -- 付款方式(1:信用卡、2匯款)
  pay_status boolean NOT NULL,                        -- 付款狀態(0:未付款、1:已付款)
  order_status Tinyint NOT NULL,                      -- 訂單狀態(1:可入住、2:已入住、3:已退房)  
  PRIMARY KEY (room_order_no)                         -- PK：room_order_no
);

INSERT INTO room_order (room_order_date, checkin_date, checkout_date, room_amount, price, payment_method, pay_status, order_status, room_type_no, mem_no) VALUES
('2023-10-04 12:00:00', '2023-10-10 14:00:00', '2023-10-12 12:00:00', 2, 3000, 1, 1, 1, 1, 1),
('2023-10-05 10:00:00', '2023-10-11 13:00:00', '2023-10-13 11:00:00', 3, 4500, 2, 2, 2, 2, 2),
('2023-10-06 15:00:00', '2023-10-14 12:00:00', '2023-10-16 10:00:00', 1, 1200, 1, 1, 1, 3, 3),
('2023-10-07 12:00:00', '2023-10-15 14:00:00', '2023-10-17 12:00:00', 2, 3600, 1, 1, 1, 1, 4),
('2023-10-08 11:00:00', '2023-10-16 13:00:00', '2023-10-18 11:00:00', 3, 5100, 2, 2, 2, 2, 5),
('2023-10-09 14:00:00', '2023-10-17 16:00:00', '2023-10-19 14:00:00', 1, 1400, 1, 1, 1, 3, 6),
('2023-10-10 13:00:00', '2023-10-18 15:00:00', '2023-10-20 13:00:00', 2, 4000, 2, 2, 2, 1, 7),
('2023-10-11 16:00:00', '2023-10-19 18:00:00', '2023-10-21 16:00:00', 3, 5700, 1, 1, 1, 2, 8),
('2023-10-12 15:00:00', '2023-10-20 17:00:00', '2023-10-22 15:00:00', 1, 1600, 2, 2, 2, 3, 9),
('2023-10-13 18:00:00', '2023-10-21 20:00:00', '2023-10-23 18:00:00', 2, 4200, 1, 1, 1, 1, 10);


DROP TABLE IF EXISTS room_type;                       -- 房型資料表
CREATE TABLE room_type (
  room_type_no int NOT NULL,                          -- 房型編號
  room_name varchar(30) NOT NULL,                     -- 房型名稱
  rtype varchar(30) NOT NULL,                         -- 房型
  room_total int NOT NULL,                            -- 房間數量
  price int NOT NULL,                                 -- 價格(原價)
  normal_price int ,                                  -- 價格(平日)
  holiday_price int ,                                 -- 價格(假日)
  bridge_holiday_price int ,                          -- 價格(連假)
  notice varchar(1000) NOT NULL,                      -- 注意事項
  facility varchar(1000) NOT NULL,                    -- 設施
  r_type_status boolean NOT NULL default 0,           -- 房型狀態(0:下架、1:上架)
  PRIMARY KEY (room_type_no)                          -- PK:room_type_no
);

INSERT INTO room_type (ROOM_TYPE_NO, ROOM_NAME, RTYPE, ROOM_TOTAL, PRICE, NORMAL_PRICE, HOLIDAY_PRICE, BRIDGE_HOLIDAY_PRICE, NOTICE, FACILITY, R_TYPE_STATUS) VALUES
(1, '豪華套房1', '單人房', 5, 1500, 1200, 1800, 2000, '附早餐', '免費Wi-Fi', 1),
(2, '豪華套房2', '單人房', 3, 2000, 1800, 2500, 2800, '附停車位', '游泳池', 1),
(3, '標準房1', '單人房', 8, 1000, 800, 1200, 1400, '不退款', '免費早餐', 1),
(4, '標準房2', '單人房', 5, 1600, 1300, 1900, 2100, '附早餐', '免費Wi-Fi', 1),
(5, '家庭套房2', '二人房', 3, 2100, 1900, 2600, 2900, '附停車位', '游泳池', 1),
(6, '家庭套房2', '二人房', 8, 1100, 900, 1300, 1500, '不退款', '免費早餐', 1),
(7, '豪華套房3', '四人房', 5, 1700, 1400, 2000, 2200, '附早餐', '免費Wi-Fi', 1),
(8, '家庭套房3', '四人房', 3, 2200, 2000, 2700, 3000, '附停車位', '游泳池', 1),
(9, '標準房3', '八人房', 8, 1200, 1000, 1400, 1600, '不退款', '免費早餐', 1),
(10, '奢華套房', '八人房', 4, 1800, 1500, 2200, 2400, '附早餐', '免費Wi-Fi', 1); 

DROP TABLE IF EXISTS room_calendar;                   -- 房型行事曆
CREATE TABLE room_calendar (               
  calendar_no int NOT NULL,                           -- 房型行事曆編號
  room_type_no int NOT NULL,                          -- 房型編號
  cdate date NOT NULL,                                -- 日期
  room_total int NOT NULL,                            -- 房間總數量
  room_booking int NOT NULL,                          -- 房間預定數量
  abailable boolean NOT NULL default 1,               -- 是否可訂房(0:不可預訂、1:可以預訂(預設))
  PRIMARY KEY (calendar_no)                           -- PK:room_type_no
);

INSERT INTO room_calendar (CALENDAR_NO, CDATE, ROOM_TOTAL, ROOM_BOOKING, abailable, ROOM_TYPE_NO) VALUES
(1, '2023-10-04', 10, 2, 8, 1),
(2, '2023-10-05', 10, 3, 7, 1),
(3, '2023-10-06', 10, 1, 9, 1),
(4, '2023-10-07', 10, 2, 8, 1),
(5, '2023-10-08', 10, 4, 6, 1),
(6, '2023-10-09', 10, 1, 9, 1),
(7, '2023-10-10', 10, 3, 7, 1),
(8, '2023-10-11', 10, 2, 8, 1),
(9, '2023-10-12', 10, 1, 9, 1),
(10, '2023-10-13', 10, 4, 6, 1);

DROP TABLE IF EXISTS room_picture;                    -- 房型照片資料表
CREATE TABLE room_picture (
  pciture_no int NOT NULL,                            -- 照片編號
  room_type_no int NOT NULL,                          -- 房型編號(FK)
  pic mediumblob NULL,                                -- 照片名稱
  PRIMARY KEY (pciture_no)                            -- PK:pciture_no
);

INSERT INTO room_picture (pciture_no, room_type_no, pic) 
VALUES 
  (1, 1, ''),
  (2, 1, ''),
  (3, 2, ''),
  (4, 2, ''),
  (5, 3, ''),
  (6, 3, ''),
  (7, 4, '');

DROP TABLE IF EXISTS room_num;                        -- 房間資料表
CREATE TABLE room_num(
  r_num int NOT NULL,                                 -- 房間號碼
  room_type_no int NOT NULL,                          -- 房間編號(FK)
  room_order_no int NOT NULL,                         -- 訂房訂單編號(FK)
  checkin_name varchar(30) NOT NULL,                  -- 住房姓名
  room_status Tinyint NOT NULL default 5 ,            -- 房間狀態(1:已入住、2:已退房、3:清潔中、4:維修中、5:已完成)
  PRIMARY KEY(r_num)                              -- PK：room_num
);

INSERT INTO room_num (R_NUM, CHECKIN_NAME, ROOM_STATUS, ROOM_TYPE_NO, ROOM_ORDER_NO) VALUES
(1, '王小明', 1, 1, 1),
(2, '王小明', 1, 1, 2),
(3, '李小華', 1, 2, 3),
(4, '李小華', 1, 2, 4),
(5, '張美麗', 1, 3, 5),
(6, '張美麗', 1, 3, 6),
(7, '陳大志', 1, 1, 7),
(8, '陳大志', 1, 1, 8),
(9, '林小玲', 1, 2, 9),
(10, '林小玲', 1, 2, 10);

-- =====================================[購物管理]===================================  
DROP TABLE IF EXISTS shop_order;
CREATE TABLE shop_order ( 
  shop_order_no int NOT NULL,                         -- 商品訂單編號
  mem_no int NOT NUll,                                -- 會員編號
  emp_no int NULL,                                    -- 員工編號
  order_amomunt int NOT NULL,                         -- 訂單總金額
  order_status boolean NOT NULL,                      -- 訂單狀態(0:取消、1:成立)
  pay_method Tinyint NOT NULL,                    -- 付款方式(1:信用卡、2匯款)
  pay_status boolean NOT NULL,                        -- 付款狀態(0:未付款、1:已付款)
  product_order_date datetime NOT NULL,               -- 訂單建立時間
  return_exchange Tinyint,							  -- 退貨/換貨(0:退貨 1:換貨)
  shipping_method Tinyint NOT NULL,                   -- 取貨方式(1:宅配、2:現場取貨)
  order_name varchar(30) NOT NULL,                    -- 收件人姓名
  order_mobile varchar(30) NULL,                      -- 收件人電話
  order_address varchar(30) NOT NULl,                 -- 收件人地址
  PRIMARY KEY (shop_order_no)                         -- PK：shop_order_no
);

INSERT INTO shop_order (shop_order_no, mem_no, emp_no, order_amomunt, order_status, pay_method, pay_status, product_order_date, return_exchange, shipping_method, order_name, order_mobile, order_address) VALUES 
(1, 101, 201, 5400, 1, 1, 1, '2023-10-04 12:34:56', NULL, 1, '王小明', '0912345678', '台北市信義區'),
(2, 102, 201, 5400, 1, 2, 0, '2023-10-03 11:23:45', NULL, 2, '李大牛', '0923456789', '新北市板橋區'),
(3, 103, 201, 4800, 0, 1, 0, '2023-09-30 09:12:34', NULL, 1, '張三', NULL, '台中市西屯區'),
(4, 104, 201, 13500, 1, 1, 1, '2023-09-29 18:45:12', NULL, 2, '李四', '0934567890', '高雄市鳳山區'),
(5, 105, 201, 2400, 1, 2, 1, '2023-09-28 08:32:41', NULL, 1, '王五', '0945678901', '台南市安平區'),
(6, 106, 201, 120000, 0, 1, 0, '2023-09-27 14:56:23', NULL, 2, '趙六', '0956789012', '新竹市東區'),
(7, 107, 201, 1200000, 1, 1, 1, '2023-09-26 10:23:45', NULL, 1, '陳七', '0967890123', '桃園市中壢區'),
(8, 108, 201, 100000, 1, 2, 0, '2023-09-25 12:34:56', NULL, 2, '黃八', NULL, '花蓮縣花蓮市'),
(9, 109, 201, 10500, 0, 1, 1, '2023-09-24 16:12:45', NULL, 1, '劉九', '0989012345', '嘉義市東區'),
(10, 110, 201, 30000, 1, 2, 1, '2023-09-23 15:45:23', NULL, 2, '楊十', '0990123456', '基隆市仁愛區');

DROP TABLE IF EXISTS product_order_detail;            -- 商品訂單明細
CREATE TABLE product_order_detail (
  shop_order_no int NOT NULL,                         -- 訂單編號
  product_no int NOT NULL,                            -- 商品編號
  order_quantity int NOT NULL,                        -- 訂購數量
  product_amount int NOT NULL,                        -- 商品付款價
  product_price int NOT NULL,                         -- 商品原價
  product_discount_price int NULL,                    -- 商品優惠價
  PRIMARY KEY (shop_order_no, product_no)             -- PK：shop_order_no, product_no
);

INSERT INTO product_order_detail (shop_order_no, product_no, order_quantity, product_amount, product_price, product_discount_price) VALUES
(1, 301, 2, 2400, 2400, NULL),
(1, 302, 2, 3000, 3000, null),
(2, 301, 3, 3600, 3600, NULL),
(2, 304, 1, 1800, 1800, null),
(3, 301, 4, 4800, 4800, null),
(4, 305, 3, 13500, 13500, null),
(5, 301, 2, 2400, 2400, null),
(6, 306, 2, 120000, 120000, NULL),
(7, 307, 1, 1200000, 1200000, null),
(8, 308, 1, 100000, 100000, null),
(9, 309, 3, 10500, 10500, NULL),
(10, 310, 2, 30000, 30000, null);


DROP TABLE IF EXISTS product;                         -- 商品資料表
CREATE TABLE product (
  product_no int NOT NULL,                            -- 商品編號
  product_category_no int NOT NULL,                   -- 商品類別編號
  product_name varchar(30) NOT NULL,                  -- 商品名稱
  product_price int NOT NULL,                         -- 商品原價
  product_quantity int NOT NULL,                      -- 商品庫存數量
  product_status boolean NOT NULL,                    -- 商品狀態(0:下架、1:上架)
  product_total_review_count int NULL,                -- 評價總人數
  product_total_review_status int NULL,               -- 評價總星數
  PRIMARY KEY (product_no)                            -- PK：product_no
);

INSERT INTO product (product_no, product_category_no, product_name, product_price, product_quantity, product_status, product_total_review_count, product_total_review_status) VALUES
(301, 1, 'Paradisiac魔法棒', 1200, 100, 1, null, null),
(302, 2, 'Paradisiac公主裙', 1500, 50, 1, null, null),
(303, 3, 'Paradisiac色筆組', 300, 30, 1, null, null),
(304, 4, 'Paradisiac主題床單', 1800, 25, 1, null, null),
(305, 5, 'Paradisiac限量音樂盒', 4500, 40, 1, null, null),
(306, 6, 'Louis Vuitton Monogram手袋', 60000, 200, 1, null, null),
(307, 7, '勞力士Day-Date鑽石錶', 1200000, 70, 1, null, null),
(308, 8, 'Chanel小黑裙', 100000, 15, 1, null, null),
(309, 9, 'Dior J_adore香水', 3500, 10, 1, null, null),
(310, 10, 'Hermès絲綢裝飾枕頭', 15000, 20, 1, null, null);


DROP TABLE IF EXISTS product_category;                -- 商品類別資料表
CREATE TABLE product_category (
  product_category_no int NOT NULL AUTO_INCREMENT,    -- 商品類別編號
  product_category_name varchar(30) NOT NULL,         -- 商品類別名稱
  product_category_desc varchar(1000) NULL,           -- 商品類別敘述
  PRIMARY KEY (product_category_no)                    -- PK：roduct_category
);

INSERT INTO product_category (product_category_name, product_category_desc) VALUES
('玩具與公仔', '包括了Paradisiac角色的玩偶或動作人偶'),
('服裝與配件', 'T恤、帽子、書包，甚至是專為特定Paradisiac角色或電影設計的服裝'),
('文具用品', '這裡可以包括筆記本、鉛筆、書包等，都會帶有Paradisiac角色的圖案或設計'),
('家居用品', '如床單、抱枕、餐具等，也會有Paradisiac角色或故事主題'),
('收藏品', '限量版的藝術品、模型或是成人收藏用的高級玩具等'),
('手袋與皮件', '包括名牌手袋、皮夾、行李箱等，這些通常是由高級材料製成並具有出色的工藝'),
('珠寶與鐘錶', '如鑽石戒指、名表等，這類商品通常是手工製作並使用高價材料'),
('高端服裝', '包括訂製服、名牌禮服或高級休閒服，這些服裝往往由知名設計師或品牌推出'),
('香水與美妝', '高端品牌的香水或化妝品，不僅品質上乘，包裝也經常是一件藝術品'),
('家居與裝飾品', '如高級家具、藝術品或其他裝飾物，這些商品通常由知名設計師設計，或是限量生產');

DROP TABLE IF EXISTS product_photo;                   -- 商品相片資料表
CREATE TABLE product_photo (
  product_photo_no int NOT NULL,                      -- 商品相片編號
  product_no int NOT NULL,                            -- 商品編號
  product_photo mediumblob NULL,                      -- 商品圖片
  PRIMARY KEY (product_photo_no)                      -- 商品相片編號                   
);

INSERT INTO product_photo (product_photo_no, product_no, product_photo) VALUES 
(1, 301, CAST('TEST' AS BINARY)),
(2, 302, CAST('TEST' AS BINARY)),
(3, 303, CAST('TEST' AS BINARY)),
(4, 304, CAST('TEST' AS BINARY)),
(5, 305, CAST('TEST' AS BINARY)),
(6, 306, CAST('TEST' AS BINARY)),
(7, 307, CAST('TEST' AS BINARY)),
(8, 308, CAST('TEST' AS BINARY)),
(9, 309, CAST('TEST' AS BINARY)),
(10, 310, CAST('TEST' AS BINARY));

DROP TABLE IF EXISTS promotion_product_detail;        -- 促銷商品明細
CREATE TABLE promotion_product_detail (
  product_no int NOT NULL,                            -- 商品編號(FK)
  promotion_no int NOT NULL,                          -- 促銷編號(FK)
  PRIMARY KEY (product_no,promotion_no)               -- PK:product_no,promotion_no  <---待確認
);

INSERT INTO promotion_product_detail (product_no, promotion_no)
VALUES
  (1, 101),
  (2, 102),
  (3, 103),
  (4, 104),
  (5, 105),
  (6, 106),
  (7, 107),
  (8, 108),
  (9, 109),
  (10, 110);

DROP TABLE IF EXISTS promotion;                       -- 促銷專案
CREATE TABLE promotion (
  promotion_no int NOT NULL,                          -- 促銷編號
  promotion_name varchar(30) NOT NULL,                -- 促銷專案名稱
  promotion_describtion varchar(30) NULL,               -- 促銷專案描述
  promotion_start_date datetime NOT NULL,             -- 促銷專案開始日期
  promotion_end_date datetime NULL,                   -- 促銷專案結束日期
  promotion_discount numeric(3,2) NOT NULL,           -- 促銷專案折扣  
  promotion_status boolean NOT NULL,                  -- 促銷專案狀態
  PRIMARY KEY (promotion_no)                          -- PK：promotion_no
);

INSERT INTO promotion (promotion_no, promotion_name, promotion_describtion, promotion_start_date, promotion_end_date, promotion_discount, promotion_status)
VALUES
  (101, '夏季特惠', '熱銷商品優惠', '2023-06-01 00:00:00', '2023-06-30 23:59:59', 0.15, true),
  (102, '清涼一夏', '暑期限定優惠', '2023-07-15 00:00:00', '2023-08-15 23:59:59', 0.10, true),
  (103, '秋季新品', '秋冬系列上市', '2023-09-01 00:00:00', '2023-09-30 23:59:59', 0.20, true),
  (104, '感恩節特賣', '感恩節慶祝優惠', '2023-11-01 00:00:00', '2023-11-30 23:59:59', 0.25, true),
  (105, '聖誕狂歡', '聖誕節特別優惠', '2023-12-10 00:00:00', '2023-12-25 23:59:59', 0.30, true),
  (106, '新年好運', '迎接新年折扣', '2024-01-01 00:00:00', '2024-01-15 23:59:59', 0.15, true),
  (107, '情人節驚喜', '情人節浪漫優惠', '2024-02-01 00:00:00', '2024-02-14 23:59:59', 0.10, true),
  (108, '春季搶鮮', '春季新品特價', '2024-03-01 00:00:00', '2024-03-31 23:59:59', 0.20, true),
  (109, '五一勞動節', '五一勞動節慶祝', '2024-05-01 00:00:00', '2024-05-05 23:59:59', 0.15, true),
  (110, '母親節感恩', '母親節特別優惠', '2024-05-10 00:00:00', '2024-05-12 23:59:59', 0.10, true);

-- =====================================[活動管理]===================================
DROP TABLE IF EXISTS act;                             -- 活動 
CREATE TABLE act (
  act_no int NOT NULL,                                -- 活動編號
  act_name varchar(30) NOT NULL,                      -- 活動名稱
  unit_price int NOT NULL,                            -- 參加費用
  low_num int NOT NULL,                               -- 最低成團人數
  high_num int NOT NULL,                              -- 最高上限人數
  act_status boolean NOT NULL default 0,              -- 活動狀態(0:下架、1：上架)
  act_content varchar(1000) NOT NULL,                 -- 活動內容
  PRIMARY KEY (act_no)                                -- PK:act_no
);
-- 將資料插入到 'act' 表格中
INSERT INTO act (act_no, act_name, unit_price, low_num, high_num, act_status, act_content)
VALUES
  (1, '浮淺冒險', 500, 10, 20, 1, '加入我們，在海中進行悠遊冒險。'),
  (2, '瑜伽療癒', 1000, 5, 30, 1, '在一個寧靜的地方，放鬆並恢復活力，參加我們的瑜伽療癒活動。'),
  (3, '烹飪課程', 500, 8, 5, 1, '與我們的專家廚師一起學習烹飪美味的菜餚。'),
  (4, '藝術工作坊', 800, 6, 5, 1, '在我們的藝術工作坊中發揮你的創造力。'),
  (5, '音樂會之夜', 100, 20, 15, 1, '在我們的音樂會上享受音樂和娛樂之夜。');

-- 檢查 'act' 表格以驗證資料
SELECT * FROM act;


DROP TABLE IF EXISTS schd;                            -- 檔期資料表
CREATE TABLE schd(
	schd_no int NOT NULL,                             -- 檔期編號
    act_no int NOT NULL,                              -- 活動編號
    anc_date datetime NULL,                           -- 上架日期
    drop_schd_date datetime NULL,                     -- 下架日期
    holddate datetime NOT NULL,                       -- 活動舉辦日期
    aplytime datetime NOT NULL,                       -- 報名開始時間
    aplydate datetime NOT NULL,                       -- 報名截止時間
    unit_price int NOT NULL,                          -- 參加費用
    low_num int NOT NULL,                             -- 最低成團人數
    high_num int NOT NULL,                            -- 最高上限人數
    unpaid_num int default 0,                         -- 未撽費人數
    paid_num int default 0,                           -- 已撽費人數
    appl_status Tinyint NOT NULL,                     -- 報名狀態(1:報名中、2:成團、3:未成團、4:因故取消)
    PRIMARY KEY(schd_no)                              -- PK：schd_no   
);
-- 插入資料到 'schd' 表格
INSERT INTO schd (schd_no, act_no, anc_date, drop_schd_date, holddate, aplytime, aplydate, unit_price, low_num, high_num, unpaid_num, paid_num, appl_status)
VALUES
  (1, 1, '2023-10-10 10:00:00', '2023-10-15 18:00:00', '2023-11-05 14:00:00', '2023-09-20 09:00:00', '2023-10-05 23:59:59', 30, 5, 20, 0, 0, 1),
  (2, 2, '2023-09-15 08:00:00', '2023-09-30 18:00:00', '2023-10-20 16:00:00', '2023-09-10 10:00:00', '2023-09-25 23:59:59', 50, 10, 30, 0, 0, 1),
  (3, 3, '2023-08-20 12:00:00', '2023-09-10 18:00:00', '2023-09-25 10:00:00', '2023-08-15 11:00:00', '2023-09-05 23:59:59', 40, 8, 15, 0, 0, 1),
  (4, 4, '2023-07-10 09:00:00', '2023-07-30 18:00:00', '2023-08-15 15:30:00', '2023-07-05 08:00:00', '2023-07-25 23:59:59', 25, 6, 12, 0, 0, 1),
  (5, 5, '2023-06-25 14:00:00', '2023-07-10 18:00:00', '2023-07-30 20:00:00', '2023-06-20 13:00:00', '2023-07-01 23:59:59', 60, 20, 50, 0, 0, 1);

-- 檢查 'schd' 表格以驗證資料
SELECT * FROM schd;



DROP TABLE IF EXISTS act_order;                       -- 活動訂單資料表
CREATE TABLE act_order(
	act_order_no int NOT NULL,                        -- 活動訂單編號
    mem_no int NOT NULL,                              -- 會員編號
    schd_no int NOT NULL,                             -- 檔期編號
    emp_no int null,                                  -- 員工編號
    order_time datetime NOT NULL,                     -- 訂單日期
    a_atn_num int NOT NULL,                           -- 報名人數
    order_status boolean NOT NULL,                    -- 訂單狀態(0:取消、2:成立)
    pay_method Tinyint NOT NULL,                      -- 付款方式(1:信用卡、2:匯款)
    pay_status boolean NOT NULL,                      -- 付款狀態(0:未付款、2:已付款)
    pay_time datetime NULL,                           -- 付款時間
    order_amount int NOT NULL,                        -- 訂金總金額
	PRIMARY KEY(act_order_no)                         -- PK：act_order_no
);

INSERT INTO `act_order` VALUES 
(1,101,201,NULL,'2023-10-04 10:00:00',2,1,1,1,'2023-10-04 10:30:00',2000),
(2,102,202,NULL,'2023-10-05 11:00:00',3,1,2,1,'2023-10-05 11:30:00',3000),
(3,103,203,NULL,'2023-10-06 12:00:00',1,1,1,0,NULL,1000),
(4,104,204,NULL,'2023-10-07 13:00:00',4,1,2,0,NULL,4000),
(5,105,205,NULL,'2023-10-08 14:00:00',2,1,1,1,'2023-10-08 14:30:00',2000),
(6,106,206,NULL,'2023-10-09 15:00:00',3,1,2,0,NULL,3000),
(7,107,207,NULL,'2023-10-10 16:00:00',1,1,1,1,'2023-10-10 16:30:00',1000),
(8,108,208,NULL,'2023-10-11 17:00:00',4,1,2,1,'2023-10-11 17:30:00',4000),
(9,109,209,NULL,'2023-10-12 18:00:00',2,1,1,0,NULL,2000),
(10,110,210,NULL,'2023-10-13 19:00:00',3,1,2,0,NULL,3000);

DROP TABLE IF EXISTS act_attendees;                   -- 活動參加人資料表
CREATE TABLE act_attendees(
	atn_no int NOT NULL,                              -- 參加人編號
    act_order_no int NOT NULL,                        -- 活動訂單編號
    atn_name varchar(30) NOT NULL,                    -- 參加人姓名
    atn_id_number char(10) NOT NULL,                  -- 參加人身份證字號
    atn_tel varchar(20) NOT NULL,                     -- 參加人電話
	PRIMARY KEY(atn_no)                               -- PK：atn_no
);
-- 插入資料到 'act_attendees' 表格
INSERT INTO `act_attendees` VALUES 
(1,101,'張三','A123456789','123-456-7890'),
(2,102,'李四','B987654321','456-789-0123'),
(3,103,'王五','C456789012','789-012-3456'),
(4,104,'陳六','D789012345','012-345-6789'),
(5,105,'趙七','E234567890','234-567-8901'),
(6,106,'鄭八','F345678901','345-678-9012'),
(7,107,'朱九','G456789012','456-789-0123'),
(8,108,'吳十','H567890123','567-890-1234'),
(9,109,'許十一','I678901234','678-901-2345'),
(10,110,'周十二','J789012345','789-012-3456');




DROP TABLE IF EXISTS act_photo;                       -- 活動相片資料表
CREATE TABLE act_photo(
	act_photo_no int NOT NULL,                        -- 活動相片編號
    act_no int NOT NULL,                              -- 活動編號
    photo mediumblob,                                 -- 活動
    photo_name varchar(60),
	PRIMARY KEY(act_photo_no)
);
-- 插入資料到 'act_photo' 表格
INSERT INTO act_photo (act_photo_no, act_no, photo, photo_name)
VALUES
  (1, 1, NULL, 'Hiking Photo 1'),
  (2, 1, NULL, 'Hiking Photo 2'),
  (3, 2, NULL, 'Yoga Retreat Photo 1'),
  (4, 3, NULL, 'Cooking Class Photo 1'),
  (5, 5, NULL, 'Concert Night Photo 1');

-- 檢查 'act_photo' 表格以驗證資料
SELECT * FROM act_photo;


-- =====================================[會員管理]===================================
DROP TABLE IF EXISTS members;                          -- 會員資料表
CREATE TABLE members (
  mem_no int NOT NULL,                                -- 會員編號
  mem_status boolean DEFAULT 0,                       -- 帳號狀態
  mem_name varchar(30) NOT NULL,                      -- 姓名
  mem_mail varchar(30) NOT NULL,                      -- 電子信箱
  mem_account varchar(20) NOT NULL,                   -- 帳號
  mem_pass varchar(20) NOT NULL,                      -- 密碼
  mem_gender Tinyint DEFAULT 0,                       -- 性別(1:男、2:女、3:其他)
  mem_id char(10) NOT NULL,                           -- 身份證字號
  mem_bir date DEFAULT NULL,                          -- 生日
  mem_phone varchar(20) NOT NULL,                     -- 手機 
  mem_address varchar(100) DEFAULT NULL,              -- 地址
  mem_date datetime NOT NULL,                         -- 註冊時間
  PRIMARY KEY (mem_no)                                -- PK:mem_no
); 

INSERT INTO `members` VALUES 
(101,1,'張三','zhangsan@example.com','zhangsan123','password1',1,'A123456789','1990-01-15','+1234567890','台北市','2023-10-04 10:00:00'),
(102,1,'李四','lisi@example.com','lisi456','password2',2,'B987654321','1985-05-20','+2345678901','新北市','2023-10-05 11:00:00'),
(103,1,'王五','wangwu@example.com','wangwu789','password3',1,'C456789012','1992-07-30','+3456789012','台中市','2023-10-06 12:00:00'),
(104,1,'陳六','chenliu@example.com','chenliu101','password4',2,'D789012345','1988-03-10','+4567890123','高雄市','2023-10-07 13:00:00'),
(105,1,'趙七','zhaoqi@example.com','zhaoqi2023','password5',1,'E234567890','1995-09-25','+5678901234','台南市','2023-10-08 14:00:00'),
(106,1,'鄭八','zhengba@example.com','zhengba008','password6',2,'F345678901','1987-11-18','+6789012345','桃園市','2023-10-09 15:00:00'),
(107,1,'朱九','zhujiu@example.com','zhujiu999','password7',1,'G456789012','1998-04-05','+7890123456','新竹市','2023-10-10 16:00:00'),
(108,1,'吳十','wushi@example.com','wushi110','password8',2,'H567890123','1986-12-02','+8901234567','基隆市','2023-10-11 17:00:00'),
(109,1,'許十一','xushiyi@example.com','xushiyi11','password9',1,'I678901234','1993-06-15','+9012345678','嘉義市','2023-10-12 18:00:00'),
(110,1,'周十二','zhoushier@example.com','zhoushier12','password10',2,'J789012345','1991-02-28','+0123456789','彰化市','2023-10-13 19:00:00');

DROP TABLE IF EXISTS photo_album;                     -- 紀念相簿資料表
CREATE TABLE photo_album (
  alb_no int NOT NULL,                                -- 相簿編號
  mem_no int NOT NULL,                                -- 會員編號
  alb_name varchar(30),                               -- 相簿名稱
  alb_photo mediumblob,                               -- 相簿封面
  alb_date date NOT NULL,                             -- 相簿日期
  PRIMARY KEY (alb_no)                           -- PK：photo_album
);
-- 插入資料到 'photo_album' 表格
INSERT INTO photo_album (alb_no, mem_no, alb_name, alb_photo, alb_date)
VALUES
  (1, 101, '旅行相簿 1', null, '2023-10-01'),
  (2, 102, '家庭相簿 1', null, '2023-09-15'),
  (3, 103, '活動相簿 1', null, '2023-09-20');


-- 檢查 'photo_album' 表格以驗證資料
SELECT * FROM photo_album;


DROP TABLE IF EXISTS photo;                           -- 紀念相片資料表
CREATE TABLE photo (
  photo_no int NOT NULL,                              -- 相片編號
  alb_no int NOT NULL,                                -- 相簿編號
  photo_name varchar(30) NOT NULL,                    -- 相片名稱
  photo mediumblob,                                   -- 相片
  photo_date datetime NOT NULL,                       -- 相片上傳時間
  PRIMARY KEY (photo_no)                              -- PK：photo_no               
);

-- 插入資料到 'photo' 表格
INSERT INTO photo (photo_no, alb_no, photo_name, photo, photo_date)
VALUES
  (1, 101, '活動合照 1',null , '2023-10-05 14:30:00'),
  (2, 101, '活動合照 2',null , '2023-10-06 10:15:00'),
  (3, 102, '聚餐照片 1',null , '2023-09-25 18:45:00'),
  (4, 103, '聚餐照片 2',null , '2023-09-20 16:00:00'),
  (5, 102, '聚餐照片 3',null , '2023-09-30 11:20:00');

-- 檢查 'photo' 表格以驗證資料
SELECT * FROM photo;


DROP TABLE IF EXISTS cs_messages;                     -- 客服訊息資料表
CREATE TABLE cs_messages (
  cs_msg_no int NOT NULL,                             -- 客服編號
  mem_no int NOT NULL,                                -- 會員編號
  emp_no int DEFAULT NULL,                            -- 員工編號
  cs_content varchar(300) NOT NULL,                   -- 申訴內容
  cs_ask_date datetime NOT NULL,                      -- 申訴時間
  cs_reply varchar(300) DEFAULT NULL,                 -- 客服回應
  cs_re_date datetime,                                -- 回應時間
  PRIMARY KEY (cs_msg_no)                             -- PK：cs_msg_no
);

INSERT INTO `cs_messages` VALUES 
(1,101,NULL,'我遇到了問題1','2023-10-04 10:00:00',
'感謝您的回應1','2023-10-04 11:00:00'),
(2,102,NULL,'我遇到了問題2','2023-10-05 11:00:00',NULL,NULL),
(3,103,NULL,'我遇到了問題3','2023-10-06 12:00:00','感謝您的回應3','2023-10-06 13:00:00'),
(4,104,NULL,'我遇到了問題4','2023-10-07 13:00:00','感謝您的回應4','2023-10-07 14:00:00'),
(5,105,NULL,'我遇到了問題5','2023-10-08 14:00:00','感謝您的回應5','2023-10-08 15:00:00'),
(6,106,NULL,'我遇到了問題6','2023-10-09 15:00:00','感謝您的回應6','2023-10-09 16:00:00'),
(7,107,NULL,'我遇到了問題7','2023-10-10 16:00:00','感謝您的回應7','2023-10-10 17:00:00'),
(8,108,NULL,'我遇到了問題8','2023-10-11 17:00:00',NULL,NULL),
(9,109,NULL,'我遇到了問題9','2023-10-12 18:00:00','感謝您的回應9','2023-10-12 19:00:00'),
(10,110,NULL,'我遇到了問題10','2023-10-13 19:00:00',NULL,NULL);

-- =====================================[後臺權限管理]===================================
DROP TABLE IF EXISTS employee;                        -- 員工資料表
CREATE TABLE employee(
  emp_no int NOT NULL,                                -- 員工帳號編號
  dept_no int NOT NULL,                               -- 部門編號
  emp_status boolean NOT NULL,                        -- 帳號狀態
  emp_name varchar(30) NOT NULL,                      -- 姓名
  emp_mail varchar(30) NOT NULL,                      -- 電子信箱
  emp_account varchar(20) NOT NULL,                   -- 帳號
  emp_pass varchar(20) NOT NULL,                      -- 密碼
  emp_gender Tinyint NOT NULL,                        -- 性別(1:男、2:女、3:其他)
  emp_phone varchar(20) NOT NULL,                     -- 手機
  PRIMARY KEY(emp_no)                                 -- PK：emp_no
);
-- 插入資料到 'employee' 表格
INSERT INTO employee (emp_no, dept_no, emp_status, emp_name, emp_mail, emp_account, emp_pass, emp_gender, emp_phone)
VALUES
  (1, 101, 1, '張三', 'zhang.san@example.com', 'zhangsan', 'password1', 1, '123-456-7890'),
  (2, 102, 1, '李四', 'li.si@example.com', 'lisi', 'password2', 1, '987-654-3210'),
  (3, 103, 1, '王五', 'wang.wu@example.com', 'wangwu', 'password3', 2, '234-567-8901'),
  (4, 101, 1, '陳六', 'chen.liu@example.com', 'chenliu', 'password4', 1, '345-678-9012'),
  (5, 102, 1, '趙七', 'zhao.qi@example.com', 'zhaoqi', 'password5', 2, '456-789-0123');

-- 檢查 'employee' 表格以驗證資料
SELECT * FROM employee;


DROP TABLE IF EXISTS department;                      -- 部門群組資料表
CREATE TABLE department(
  dept_no int NOT NULL,                               -- 部門編號
  dept_name varchar(20) NOT NULL,                     -- 部門名稱
  PRIMARY KEY(dept_no)                                -- PK：dept_no
);
-- 插入資料到 'department' 表格
INSERT INTO department (dept_no, dept_name)
VALUES
  (101, '業務部'),
  (102, '房務部'),
  (103, '人資部'),
  (104, '企劃部');


-- 檢查 'department' 表格以驗證資料
SELECT * FROM department;



DROP TABLE IF EXISTS fuc;                             -- 功能
CREATE TABLE fuc(
  fuc_no int NOT NULL,                                -- 功能編號 
  fuc_name varchar(20),                               -- 功能名稱
  PRIMARY KEY(fuc_no)                                 -- PK：fuc_no
);
-- 插入資料到 'fuc' 表格
INSERT INTO fuc (fuc_no, fuc_name)
VALUES
  (101, '會員'),
  (102, '購物'),
  (103, '客服'),
  (104, '紀念相簿'),
  (105, '訂房'),
  (106, '後台員工權限'),
  (107, '最新消息'),
  (108, '活動');

-- 檢查 'fuc' 表格以驗證資料
SELECT * FROM fuc;


DROP TABLE IF EXISTS department_acce;                 -- 群組權限資料表
CREATE TABLE department_acce(
  dept_no int NOT NULL,                               -- 部門編號
  fuc_no int NOT NULL,                                -- 功能編號
  PRIMARY KEY(dept_no)                         -- PK：dept_no,fun_no   <--待確認
);
-- 插入資料到 'department_acce' 表格
INSERT INTO department_acce (dept_no, fuc_no)
VALUES
  (1, 101),
  (2, 102),
  (3, 103),
  (4, 104);


-- 檢查 'department_acce' 表格以驗證資料
SELECT * FROM department_acce;

-- ALTER TABLE department_acce
-- ADD CONSTRAINT fk_dept_acce_dept
-- FOREIGN KEY (dept_no) REFERENCES department(dept_no);

-- ALTER TABLE department_acce
-- ADD CONSTRAINT fk_dept_acce_fuc
-- FOREIGN KEY (fuc_no) REFERENCES fuc(fuc_no);



-- =====================================[最新消息管理]===================================
DROP TABLE IF EXISTS news;                            -- 最新消息資料表
CREATE TABLE news( 
  news_no int NOT NULL,                               -- 消息編號
  anoc_time datetime,                                 -- 發布時間
  drop_time datetime,                                 -- 下架時間
  news_title varchar(100) NOT NULL,                   -- 消息標題
  news_type Tinyint NOT NULL,                         -- 消息類別
  news_cont varchar(3000),                            -- 消息內容 
  top_title Tinyint,                                  -- 置頂層級 
  PRIMARY KEY(news_no)                                -- PK：news_no  
);
-- 插入資料到 'news' 表格（以飯店網站為例）
INSERT INTO news (news_no, anoc_time, drop_time, news_title, news_type, news_cont, top_title)
VALUES
  (1, '2023-10-05 09:00:00', '2023-10-12 18:00:00', '特價優惠', 1, '秋季特價優惠開始啦！預訂我們的豪華套房，享受超值優惠價格。', 1),
  (2, '2023-09-20 10:00:00', '2023-09-30 20:00:00', '新設施開放', 2, '我們的新游泳池和健身中心現已開放使用。歡迎來品味一下。', 2),
  (3, '2023-08-15 15:00:00', '2023-08-31 22:00:00', '節日慶祝', 1, '我們將在這個假期期間舉辦特別的慶祝活動。加入我們一起慶祝吧！', NULL),
  (4, '2023-07-10 08:00:00', '2023-07-15 20:00:00', '會議設施', 3, '我們提供現代化的會議設施，是舉辦商務會議的理想地點。', NULL),
  (5, '2023-06-25 12:00:00', '2023-06-30 18:00:00', '夏日沙灘派對', 2, '加入我們的夏日沙灘派對，享受陽光、海灘和美食。', NULL);

-- 檢查 'news' 表格以驗證資料
SELECT * FROM news;


-- =====================================[客服機器人]===================================

DROP TABLE IF EXISTS robot;                           -- 客服機器人
CREATE TABLE robot(
robot_no int NOT NULL,                                -- 關鍵字編號
robot_word varchar(20) NOT NULL,                      -- 關鍵字
robot_content varchar(600) NOT NULL,                  -- 回覆內容
PRIMARY KEY(robot_no)                      
);
INSERT INTO `robot` VALUES 
(1,'你好','您好！有什麼我可以幫助您的？'),
(2,'關於我們','我們是一個客服機器人團隊，專注於解答您的問題。'),
(3,'產品詳情','請提供更多關於產品的詳細信息，我們將樂意回答您的問題。'),
(4,'聯絡我們','您可以在聯絡我們頁面找到我們的聯絡方式。'),
(5,'訂單問題','請提供訂單號碼，我們將盡快為您處理訂單相關問題。'),
(6,'會員登錄','請提供您的會員帳號和密碼以進行登錄。'),
(7,'忘記密碼','如果您忘記了密碼，請點擊“忘記密碼”以重設密碼。'),
(8,'優惠碼','如果您有優惠碼，請在結帳時輸入以享受折扣。'),
(9,'退貨政策','我們的退貨政策允許在特定條件下退貨。請參考我們的網站上的退貨政策頁面。'),
(10,'購物流程','購物流程包括選擇產品、將其添加到購物車、結帳和付款。有其他問題嗎？');



-- =====================================[以下是外來鍵設定範例]==========================



-- ALTER TABLE CUSTOMER
-- ADD CONSTRAINT CUSTOMER_CUSTID_CK CHECK ((CUSTID > 0));

-- ALTER TABLE EMP
-- ADD CONSTRAINT EMP_DEPTNO_FK FOREIGN KEY (DEPTNO) REFERENCES DEPT(DEPTNO);

-- ALTER TABLE EMP
-- ADD CONSTRAINT EMP_MGR_FK FOREIGN KEY (MGR) REFERENCES EMP(EMPNO);

-- ALTER TABLE ORD
-- ADD CONSTRAINT ORD_CUSTID_FK FOREIGN KEY (CUSTID) REFERENCES CUSTOMER(CUSTID);

-- ALTER TABLE ORD
-- ADD CONSTRAINT ORD_TOTAL_CK CHECK ((TOTAL >= 0));

-- ALTER TABLE ITEM
-- ADD CONSTRAINT ITEM_ORDID_FK FOREIGN KEY (ORDID) REFERENCES ORD(ORDID);

-- ALTER TABLE ITEM
-- ADD CONSTRAINT ITEM_PRODID_FK FOREIGN KEY (PRODID) REFERENCES PRODUCT(PRODID);

-- ALTER TABLE PRICE
-- ADD CONSTRAINT PRICE_PRODID_FK FOREIGN KEY (PRODID) REFERENCES PRODUCT(PRODID);