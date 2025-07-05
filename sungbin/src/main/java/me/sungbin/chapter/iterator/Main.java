package me.sungbin.chapter.iterator;

public class Main {
    public static void main(String[] args) {
        NewsFeed newsFeed = createSampleNewsFeed();

        System.out.println("뉴스 피드");
        newsFeed.displayAllArticles();

        System.out.println("\n" + "=".repeat(50));
        System.out.println("Displaying only IT category:");
        newsFeed.displayCategoryArticles("IT");
    }

    private static NewsFeed createSampleNewsFeed() {
        NewsFeed newsFeed = new NewsFeed();

        newsFeed.addCategory("정치");
        newsFeed.addCategory("스포츠");
        newsFeed.addCategory("IT");

        newsFeed.addArticleToCategory("정치",
                new NewsArticle("국정감사 시작", "2024년 국정감사가 시작되었습니다.", "정치부 기자"));
        newsFeed.addArticleToCategory("정치",
                new NewsArticle("예산안 논의", "내년도 예산안에 대한 논의가 진행중입니다.", "경제부 기자"));

        newsFeed.addArticleToCategory("스포츠",
                new NewsArticle("프로야구 시즌 종료", "2024 프로야구 정규시즌이 종료되었습니다.", "박문성 기자"));
        newsFeed.addArticleToCategory("스포츠",
                new NewsArticle("축구 국가대표 명단 발표", "11월 A매치 국가대표 명단이 발표되었습니다.", "KFA 기자"));

        newsFeed.addArticleToCategory("IT",
                new NewsArticle("AI 기술 발전", "최신 AI 기술의 놀라운 발전이 보고되었습니다.", "정철희"));
        newsFeed.addArticleToCategory("IT",
                new NewsArticle("새로운 프로그래밍 언어", "혁신적인 프로그래밍 언어가 공개되었습니다.", "김찬우"));

        return newsFeed;
    }
}
