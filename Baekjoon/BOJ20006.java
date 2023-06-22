import java.util.*;
import java.io.*;

public class BOJ20006 {
    static class Player{
        int level;
        String nickName;

        Player(int level, String nickName){
            this.level = level;
            this.nickName = nickName;
        }

        public String toString(){
            return level + " " + nickName;
        }
    }

    static class Room{
        int roomLevel;
        List<Player> playerList = new ArrayList<>();

        Room(Player player){
            this.roomLevel = player.level;
            playerList.add(player);
        }

        public boolean validateLevel(int playerLevel){
            return (roomLevel - 10 <= playerLevel) && (playerLevel <= roomLevel + 10);
        }

        public boolean isFull(){
            return playerList.size() == m;
        }
    }

    private static final String WAITING = "Waiting!", STARTED = "Started!";
    private static int p, m;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<Room> roomList = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        init();

        // process
        StringTokenizer st;
        for(int i = 0; i < p; i++){
            st = new StringTokenizer(br.readLine());
            Player thisPlayer = new Player(Integer.parseInt(st.nextToken()), st.nextToken());

            putPlayerInRoom(thisPlayer);
        }

        // confirm room

        printAnswer();
    }

    private static void printAnswer(){
        for(Room room : roomList){
            // 시작 / 대기 여부 출력
            System.out.println((room.isFull() ? STARTED : WAITING));

            // 닉네임 사전순 정렬
            Collections.sort(room.playerList, new Comparator<Player>(){
                public int compare(Player o1, Player o2){
                    return o1.nickName.compareTo(o2.nickName);
                }
            });

            // 출력
            for(Player player : room.playerList){
                System.out.println(player);
            }
        }
    }

    private static void putPlayerInRoom(Player player){
        boolean playerInserted = false;
        for(Room room : roomList){
            // 방이 꽉찬 경우
            if(room.isFull())
                continue;

            if(room.validateLevel(player.level)){
                room.playerList.add(player);
                playerInserted = true;
                break;
            }
        }

        // 방에 입장하지 못했으면
        if(!playerInserted){
            roomList.add(new Room(player));
        }
    }

    private static void init() throws IOException{
        StringTokenizer st;

        // set p, m
        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
    }
}



/*
자신과 비슷한 플레이어 매칭

1. 입장 가능한 방 X => 신규 방 생성 (+- 10까지 입장 가능)
2. 입장 가능한 방 O => 정원 다 찰 때까지 대기 (먼저 생성된 순으로 입장)
3. 방 정원 다 차면 게임 시작

class player => 선수 레벨, 닉네임, toString

class room => 방 level, player List // validate => list.size가 roomSize 초과하는가 // comparator를 통해 출력 전에 playerList를 사전순으로 정렬
List<room>
 */