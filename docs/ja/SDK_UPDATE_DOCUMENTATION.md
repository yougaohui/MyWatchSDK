# 温度チェックSDK更新ドキュメント

バージョン: 2.0  
更新日: 2025-12-05

---

## 概要

今回のアップデートは、温度チェック機能のプロトコル拡張とバグ修正を中心に、心拍PPIとリスクステータスフィールドを追加し、後方互換性を維持するためにデータ解析ロジックを最適化しました。

## 主な更新内容

### 1. TempCheckModelの拡張

**新規フィールド：**

| フィールド名 | 型 | 説明 | デフォルト値 |
|-------------|-----|------|-------------|
| heartRatePPI | int | 心拍PPI値（リトルエンディアン） | 0 |
| riskStatus | int | リスクステータス（0=正常、1=中リスク、2=高リスク） | 0 |
| extraData | byte[] | 将来のプロトコル拡張用の追加データ | null |

**新規メソッド：**
- `int getHeartRatePPI()` - 心拍PPI値を取得
- `int getRiskStatus()` - リスクステータス値を取得
- `String getRiskStatusText()` - リスクステータステキストを取得
- `byte[] getExtraData()` - 追加拡張データを取得

**ファイルパス：**
`mywatchsdklib/src/main/java/com/legend/mywatch/sdk/mywatchsdklib/android/model/TempCheckModel.java`

### 2. プロトコル解析の最適化

**2.1 プロトコル構造（72bit/9バイト対応）**

| バイト位置 | ビット数 | フィールド | 説明 |
|-----------|---------|-----------|------|
| 1-4 | 32bit | 基本データ | timestamp(11bit) + temperature(13bit) + powerOnCount(8bit) |
| 5-8 | 32bit | heartRatePPI | 心拍PPI（リトルエンディアン） |
| 9 | 8bit | riskStatus | リスクステータス |
| 10+ | 可変 | extraData | 追加データ（オプション） |

**2.2 解析ロジックの修正**

- **心拍PPIバイト順の修正：** ビッグエンディアンからリトルエンディアンに変更
  - 例：`20 03 00 00` → 800 (0x320)
  
- **動的アイテム長の計算：** 4/8/9バイトなど複数のプロトコルバージョンに対応
  - 計算式：`itemLength = contentBytes.length / itemNum`
  - 旧プロトコル（4バイト）と新プロトコル（8/9バイト）に自動対応

**ファイルパス：**
`mywatchsdklib/src/main/java/com/legend/mywatch/sdk/mywatchsdklib/android/bluetooth/ReceiveData.java`

### 3. デモアプリケーションの更新

**表示の最適化：**
- ToastからAlertDialogに変更して温度チェックデータを表示
- 新規フィールドの表示を追加：心拍PPI、リスクステータス、追加データ長

**ファイルパス：**
`app/src/main/java/com/legend/mywatch/sdk/android/MainActivity.java`

## プロトコル互換性

| プロトコルバージョン | データ長 | サポートフィールド | 互換性 |
|--------------------|---------|------------------|--------|
| 旧プロトコル | 4バイト | timestamp, temperature, powerOnCount | ✅ 完全互換 |
| 心拍PPIプロトコル | 8バイト | 基本フィールド + heartRatePPI | ✅ 完全互換 |
| 完全プロトコル | 9バイト | 基本フィールド + heartRatePPI + riskStatus | ✅ 完全互換 |
| 将来の拡張 | 10+バイト | 全フィールド + extraData | ✅ 自動対応 |

## 使用例

```java
// 温度チェックデータを取得
TempCheckModel model = event.getTempCheck();

// 基本フィールド
int timestamp = model.getTimestamp();        // タイムスタンプ（分）
float temperature = model.getTemperature();  // 温度（℃）
int powerOnCount = model.getPowerOnCount();  // 起動回数

// 新規フィールド
int heartRatePPI = model.getHeartRatePPI();  // 心拍PPI
int riskStatus = model.getRiskStatus();      // リスクステータス値（0/1/2）
String riskText = model.getRiskStatusText(); // リスクステータステキスト（"正常"/"中リスク"/"高リスク"）
byte[] extraData = model.getExtraData();     // 追加データ
```

## 重要な注意事項

1. **後方互換性：** すべての新規フィールドは旧プロトコルで合理的なデフォルト値（0またはnull）を持ち、既存の機能に影響しません
2. **バイト順：** 心拍PPIはリトルエンディアンを使用
3. **拡張性：** extraDataフィールドは将来のプロトコル拡張のためのスペースを予約

---

## 変更履歴

| 日付 | バージョン | 説明 |
|-----|-----------|------|
| 2025-12-05 | 2.0 | 初版リリース |

## 連絡先

ご質問がある場合は、技術サポートチームまでお問い合わせください。

