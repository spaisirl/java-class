package prac01;

public class SongMain {

public static void main(String[] args) {
		
		Song mySong = new Song("Nessun Dorma");
		Song yourSong = new Song("공주는 잠 못 이루고");
		System.out.println("너 노래는 " + mySong.getTitle());
		System.out.println("너 노래는 " + yourSong.getTitle());

	}
}
