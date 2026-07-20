# Prediksi Gelombang Laut Menggunakan CNN-BiLSTM

## Deskripsi
Aplikasi Android untuk memprediksi tinggi gelombang laut menggunakan model CNN-BiLSTM yang telah dikonversi ke TensorFlow Lite (TFLite).

## Tools
- Google Colab
- Python 3.x
- TensorFlow 2.17
- Android Studio
- TensorFlow Lite

## Cara Menjalankan

### 1. Melatih Model
1. Install library:
   ```
   pip install -r requirements.txt
   ```
2. Jalankan notebook `PrediksiGelombang.ipynb` di Google Colab.
3. Hasil pelatihan berupa file `model_gelombang.tflite`.

### 2. Menjalankan Aplikasi Android
1. Buka project di Android Studio.
2. Pastikan file `model_gelombang.tflite` berada pada folder:
   ```
   app/src/main/assets/
   ```
3. Jalankan aplikasi pada emulator atau perangkat Android.

## Dataset
Dataset tinggi gelombang laut diperoleh dari Kaggle dan digunakan sebagai data pelatihan model.

## Author
Suryana Pitaloka
S1 Informatika - Universitas Muhammadiyah Semarang
