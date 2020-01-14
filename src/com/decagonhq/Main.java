package com.decagonhq;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {
	Album album = new Album("Stormbringer", "Deep purple");
	album.addSong("StormBringer", 4.6);
        album.addSong("Love don't mean a thing", 4.22);
        album.addSong("Holy Man", 4.3);
        album.addSong("Hold On", 5.6);
        album.addSong("Lady double dealer", 3.21);
        album.addSong("you can't do it right", 6.23);
        album.addSong("High ball Shooter", 4.27);
        album.addSong("The gypsy", 4.2);
        album.addSong("Soldier of Fortune", 3.13);
        albums.add(album);

        album = new Album("for those about to Rock", "AC/DC");
        album.addSong("For those about to rock", 4.22);
        album.addSong("I put the finger on you", 4.3);
        album.addSong("Let's Go", 5.6);
        album.addSong("Inject the Venom", 3.21);
        album.addSong("Snowballed", 6.23);
        album.addSong("Evil Walks", 4.27);
        album.addSong("C.O.D", 4.2);
        album.addSong("Breaking the Rules", 3.13);
        album.addSong("Night of the Long Knives", 4.6);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlaylist("you can't do it right", playList);
        albums.get(0).addToPlaylist("Holy Man", playList);
        albums.get(0).addToPlaylist("Speed King", playList);
        albums.get(0).addToPlaylist(9, playList);
        albums.get(1).addToPlaylist(8, playList);
        albums.get(1).addToPlaylist(3, playList);
        albums.get(1).addToPlaylist(2, playList);
        albums.get(1).addToPlaylist(24, playList);

        play(playList);





    }

    private static void play(LinkedList<Song> playList){
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0){
            System.out.println("No Songs in playList");
            return;
        }else {
            System.out.println("Now Playing " + listIterator.next().toString());
        }
    }
}
