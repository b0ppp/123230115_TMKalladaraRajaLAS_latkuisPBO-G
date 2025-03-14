package latkuis;

public class Mahasiswa {
    private String nama, nim, kelas, mataKuliah;
    private double nilaiTugas, nilaiQuiz;

    public Mahasiswa(String nama, String nim, double nilaiTugas, double nilaiQuiz,String kelas, String mataKuliah ) {
        this.nama = nama;
        this.nim = nim;
        this.nilaiTugas = nilaiTugas;
        this.nilaiQuiz = nilaiQuiz;
        this.kelas = kelas;
        this.mataKuliah = mataKuliah;
    }
    
    public double getTotalNilai(){
        if(kelas.equals("Teori")){
            return(0.3 * nilaiTugas) + (0.7 * nilaiQuiz);
        } else {
            return(0.7 * nilaiTugas) + (0.3 * nilaiQuiz);
        }
    }
    
    public String getHasil(){
        return getTotalNilai() > 85 ? "LULUS" : "TIDAK LULUS";
    }
    
    public String getInfo(){
        return "Nama: " + nama + "\n" + "NIM: " + nim + "\n" + "Mata Kuliah: " + mataKuliah + "\n" +
                "Kelas: " + kelas + "\n" + "Total Nilai: " + getTotalNilai() + "\n" +  "Hasil: " + getHasil();
    }
    
}

