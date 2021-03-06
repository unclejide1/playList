package com.decagonhq;

import java.util.*;

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
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0){
            System.out.println("No Songs in playList");
            return;
        }else {
            System.out.println("Now Playing " + listIterator.next().toString());
            printMenu();
        }
        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if(!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                    }
                        forward = true;
                        if (listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next().toString());
                        }else {
                            System.out.println("We have Reached the end of the playlist");
                            forward = false;
                        }

                    break;
                case 2:
                    if(forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                    }
                        forward = false;
                        if (listIterator.hasPrevious()){
                            System.out.println("Now Playing " + listIterator.previous().toString());
                        }else {
                            System.out.println("We are at the start of the playlist");
                            forward = true;
                        }

                    break;
                case 3:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("we are at the start of the list");
                        }
                    }else {
                        if (listIterator.hasNext()){
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        }else {
                            System.out.println("we are at the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size() >0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next());
                        }else if (listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
               "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions\n" +
                "6 - delete current song from playlist");
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("==============");
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
        System.out.println("==============");
    }
}
