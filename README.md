B2E_url_shortener
================================

## 目的
實作題目B2E ( https://hackmd.io/LhqZ-WlGRmuagawQadO5CA)

## 環境需求
* JDK 1.8+

以下為編譯之需求:
* Maven 3.x (https://maven.apache.org/install.html )
* Internet連線

## 編譯與執行
為了讓程式能盡量在本機執行, project中將deploy目錄留下來, 可直接以java執行
* windows: 執行run.bat
* linux: 執行./run.sh

若要編譯, 則在後面加compile參數:
* windows: 執行run.bat compile
* linux: 執行./run.sh compile

![run](https://github.com/maxysdf/b2e_url_shortener/blob/master/screenshot/00_run.png?raw=true)

啟動後進入 http://localhost:8888/ :
![ui](https://github.com/maxysdf/b2e_url_shortener/blob/master/screenshot/01_ui.png?raw=true)

輸入URL按shorten, 可產生短網址:
![shorten](https://github.com/maxysdf/b2e_url_shortener/blob/master/screenshot/02_shorten.png?raw=true)


## 實作說明
0. 準備可輸出之字元, 如A-Za-z0-9
1. 輸入URL後, 將URL拆解後重組 (參數互換時, 結果不變)
2. 重組後的字串分解為字元陣列
3. 準備目標長度的整數陣列
4. 將字元一一加到整數陣列中 (重覆N次以避免URL過短, 或是pattern太過固定)
5. 整數陣列分別對可輸出字元數量取餘數, 對應出輸出字元
6. 合併輸出字元, 存放至HashMap, 並輸出至UI



