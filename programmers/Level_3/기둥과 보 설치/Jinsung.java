import java.util.*;

class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        List<int[]> stick = new ArrayList<>();
        int[][] rowBox = new int[n+1][n+1];
        int[][] colBox = new int[n+1][n+1];
        
        for(int[] build : build_frame){
            // 건물을 설치하는 경우
            if(build[3]==1){
                if(checkBuild(n,build[0],build[1],build[2],rowBox,colBox)){
                    if(build[2]==1){    // 보를 설치하는 경우            
                        rowBox[build[0]][build[1]] = 1;
                    }else{  // 기둥을 설치하는 경우
                        colBox[build[0]][build[1]] = 1;
                    }
                }
            }else{  // 건물을 제거하는 경우
                if(checkRemove(n,build[0],build[1],build[2],rowBox,colBox)){
                    if(build[2]==0){    // 보를 제거하는 경우
                        rowBox[build[0]][build[1]] = 0;
                    }else{  // 기둥을 제거하는 경우
                        colBox[build[0]][build[1]] = 0;
                    }
                }
            }
        }
        // 보를 담은 rowBox와 기둥을 담은 colBox를 탐색하며 stick에 정보를 담는다. 
        calCulateBuilding(rowBox,1,stick);
        calCulateBuilding(colBox,0,stick);
        // x좌표 기준으로 오름차순 정렬하며, x좌표가 같을 경우 y좌표 기준으로 오름차순 정렬
        // x, y좌표가 모두 같은 경우 기둥이 보보다 앞으로
        Collections.sort(stick,(int[] a,int[] b) -> a[0]==b[0] ? a[1]==b[1] ? a[2]>b[2] ? 1:-1 : a[1]>b[1] ? 1:-1 : a[0]>b[0] ? 1:-1 );
        
        return stick.toArray(new int[stick.size()][3]);
    }
    
    public boolean checkBuild(int size,int x,int y,int type,int[][] rowBox,int[][] colBox){
                
         if(x<0 || x>size || y<0 || y>size)
            return false;
        
        if(type==1){   // 보 인경우
            // 보는 한쪽 끝 부분이 기둥 위에 있거나, 또는 양쪽 끝 부분이 다른 보와 동시에 연결되어 있어야 합니다.    
            if((y-1>=0 && x>=0 && colBox[x][y-1]!=0) || (x+1<=size && y-1>=0 && colBox[x+1][y-1]!=0)) return true;
            else if((x-1>=0 && rowBox[x-1][y]!=0) && (x+1<=size && rowBox[x+1][y]!=0) ) return true;
            
        }else{  // 기둥인 경우
            // 기둥은 바닥 위에 있거나 보의 한쪽 끝 부분 위에 있거나, 또는 다른 기둥 위에 있어야 합니다.
            if(y==0) return true;
            else if((x-1>=0 && rowBox[x-1][y]!=0) || (x+1<=size && rowBox[x+1][y]!=0)) return true;
            else if(y-1>=0 && colBox[x][y-1]!=0) return true;
        }
        
        return false;
    }
    
    public boolean checkRemove(int size,int x,int y,int type,int[][] rowBox,int[][] colBox){
        
        int[] dx = {1,0,0,-1};
        int[] dy = {0,-1,1,0};
        
        boolean result = true;
        if(type==1){    // 보인 경우
            rowBox[x][y] = 0;
                        
            // 왼쪽에 있는 보가 안전한지
            if(existBuilding(size,x-1,y,type,rowBox,colBox)){
                if(!checkBuild(size,x-1,y,type,rowBox,colBox)){
                    rowBox[x][y] = 1;
                    return false;
                }
            }
            // 오른쪽에 있는 보가 안전한지
            if(existBuilding(size,x+1,y,type,rowBox,colBox)){
                if(!checkBuild(size,x+1,y,type,rowBox,colBox)){
                    rowBox[x][y] = 1;
                    return false;
                }
            }
            // 왼쪽 위에 있는 기둥가 안전한지
            if(existBuilding(size,x,y,0,rowBox,colBox)){
                if(!checkBuild(size,x,y,0,rowBox,colBox)){
                    rowBox[x][y] = 1;
                    return false;
                }    
            }
            // 오른쪽 위에 있는 기둥가 안전한지
            if(existBuilding(size,x+1,y,0,rowBox,colBox)){
                if(!checkBuild(size,x+1,y,0,rowBox,colBox)){
                    rowBox[x][y] = 1;
                    return false;
                }    
            }
        }else{  // 기둥인 경우
            
            colBox[x][y] = 0;
                        
            // 위에 기둥은 안전한지
            if(existBuilding(size,x,y+1,type,rowBox,colBox)){
                if(!checkBuild(size,x,y+1,type,rowBox,colBox)){
                    colBox[x][y] = 1;
                    return false;   
                }    
            }
            // 왼쪽 위에 보가 안전한지
            if(existBuilding(size,x-1,y+1,1,rowBox,colBox)){
                if(!checkBuild(size,x-1,y+1,1,rowBox,colBox)){
                    colBox[x][y] = 1;
                    return false;
                }    
            }
            // 오른쪽 위에 보가 안전한지
            if(existBuilding(size,x,y+1,1,rowBox,colBox)){
                if(!checkBuild(size,x,y+1,1,rowBox,colBox)){
                    colBox[x][y] = 1;
                    return false;
                }    
            }
        }
        
        return result;
    }
    
    public int[] generateStick(int row,int col, int dir){
        int[] stick = new int[3];
        stick[0] = row;
        stick[1] = col;
        stick[2] = dir;
        return stick;
    }
    
    public void calCulateBuilding(int[][] building,int type,List<int[]> storage){
        
        for(int x=0;x<building.length;x++){
            for(int y=0;y<building.length;y++){
                if(building[x][y]!=0){
                    storage.add(generateStick(x,y,type));
                }
            }
        }
    }
    
    public boolean existBuilding(int size,int x, int y, int type,int[][] rowBox, int[][] colBox){
        
        if(x<0 || x>size || y<0 || y>size)
            return false;
        
        if(type==0){
            // 기둥이면
            if(colBox[x][y]!=0)
                return true;
        }else{
            // 보면
            if(rowBox[x][y]!=0)
                return true;
        }
        return false;
    }
    
}