/***
545222
KosukeFukui
***/


import java.util.*;
import java.io.*;
public class Cat{
  void run(String[] args) throws IOException{
    Boolean number = false;
  	Boolean name = false;
  	Boolean blank = false;
  	Boolean help = false;
  	int n = 0;
    int m = 0;
  	int l = 0;
    int i;

    for(String str: args){
  	   File ford = new File(str);
       if(ford.isFile()||ford.isDirectory()){
         n++;
       }
     }
    File[] file = new File[n];

    for(String str: args){
      if(Objects.equals(args[l],"-n")||Objects.equals(args[l],"--number")){
        number = true;
      }
      else if(Objects.equals(args[l],"-N")||Objects.equals(args[l],"--name")){
        name = true;
      }
  	  else if(Objects.equals(args[l],"-b")||Objects.equals(args[l],"--ignore-blank")){
  		  blank = true;
  	  }
  	  else if(Objects.equals(args[l],"-h")||Objects.equals(args[l],"--help")){
  		  help = true;
  	  }
      else{
	      file[m] = new File(args[l]);
		    m++;
      }
      l++;
    }

      if(help == true){
    	    System.out.println("-n もしくは、--number オプションをつけると番号を表示する。");
    	    System.out.println("-N もしくは、--name オプションをつけるとファイル名を表示する。");
    	    System.out.println("-b もしくは、--ignore-blank オプションをつけると空行を無視する。");
    	    System.out.println("-h もしくは、--help オプションをつけるとヘルプメッセージを表示し終了する。");
    	}else{
          if(number){
            if(name){
              if(blank){
                for(i = 0; i < n; i++){
                  this.numbernameblankwrite(file[i]);
            //      System.out.println("1");
                }
              }else{
                for(i = 0; i < n; i++){
                  this.numbernamewrite(file[i]);
            //          System.out.println("2");
                }
              }
            }else{
              if(blank){
                for(i = 0; i < n; i++){
                  this.numberblankwrite(file[i]);
            //          System.out.println("3");
                }
              }else{
                for(i = 0; i < n; i++){
                  this.numberwrite(file[i]);
              //        System.out.println("4");
                }
              }
            }
          }else{
            if(name){
              if(blank){
                for(i = 0; i < n; i++){
                  this.nameblankwrite(file[i]);
            //          System.out.println("5");
                }
              }else{
                for(i = 0; i < n; i++){
                  this.namewrite(file[i]);
          //            System.out.println("6");
                }
              }
            }else{
              if(blank){
                for(i = 0; i < n; i++){
                  this.blankwrite(file[i]);
          //            System.out.println("7");
                }
              }else{
                for(i = 0; i < n; i++){
                    this.write(file[i]);
          //              System.out.println("8");
                }
              }
            }
          }
        }
      }

  void write(File file) throws IOException{
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while((line = in.readLine()) != null){
      System.out.printf("     ");
      System.out.println(line); //1行ずつ読み込んだテキストを出力
    }
  }
  void numberwrite(File file) throws IOException{
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    int num = 0;
    while((line = in.readLine()) != null){
      System.out.printf("%5d", num);
      System.out.println(line); //1行ずつ読み込んだテキストを出力
      num++;
    }
  }
  void numberblankwrite(File file) throws IOException{
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    int num = 0;
    while((line = in.readLine()) != null){
      if(line.length() != 0){
        System.out.printf("%5d", num);
        System.out.println(line); //1行ずつ読み込んだテキストを出力
      }
      num++;
    }
  }
  void numbernamewrite(File file) throws IOException{
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    int num = 0;
    System.out.printf("===== %s =====\n",file.getName());
    while((line = in.readLine()) != null){
      System.out.printf("%5d", num);
      System.out.println(line); //1行ずつ読み込んだテキストを出力
      num++;
    }
  }
  void numbernameblankwrite(File file) throws IOException{
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    int num = 0;
    System.out.printf("===== %s =====\n",file.getName());
    while((line = in.readLine()) != null){
      if(line.length() != 0){
        System.out.printf("%5d", num);
        System.out.println(line); //1行ずつ読み込んだテキストを出力
      }
      num++;
    }
  }
  void blankwrite(File file) throws IOException{
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while((line = in.readLine()) != null){
      if(line.length() != 0){
        System.out.printf("     ");
        System.out.println(line); //1行ずつ読み込んだテキストを出力
      }
    }
  }
  void namewrite(File file) throws IOException{
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    System.out.printf("===== %s =====\n",file.getName());
    while((line = in.readLine()) != null){
      System.out.printf("     ");
      System.out.println(line); //1行ずつ読み込んだテキストを出力
    }
  }
  void nameblankwrite(File file) throws IOException{
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    System.out.printf("===== %s =====\n",file.getName());
    while((line = in.readLine()) != null){
      if(line.length() != 0){
        System.out.printf("     ");
        System.out.println(line); //1行ずつ読み込んだテキストを出力
      }
    }
  }

  public static void main(String[] args) throws IOException{
    Cat cat = new Cat();
    cat.run(args);
  }
}
