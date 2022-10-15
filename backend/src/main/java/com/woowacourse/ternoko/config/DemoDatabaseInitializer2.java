package com.woowacourse.ternoko.config;

import com.woowacourse.ternoko.core.domain.availabledatetime.AvailableDateTimeRepository;
import com.woowacourse.ternoko.core.domain.comment.CommentRepository;
import com.woowacourse.ternoko.core.domain.interview.InterviewRepository;
import com.woowacourse.ternoko.core.domain.member.coach.Coach;
import com.woowacourse.ternoko.core.domain.member.coach.CoachRepository;
import com.woowacourse.ternoko.core.domain.member.crew.Crew;
import com.woowacourse.ternoko.core.domain.member.crew.CrewRepository;
import java.util.ArrayList;
import java.util.TimeZone;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Profile({"local", "demo"})
@Component
@RequiredArgsConstructor
public class DemoDatabaseInitializer2 {
    private static final String KST = "Asia/Seoul";
    private static final String TEST_EMAIL = "@test.com";
    private static final String COACH_EMAIL = "@woowahan.com";

    private final DemoDatabaseInitializer2.InitService initService;

    @PostConstruct
    public void init() {
        setTimeZone(TimeZone.getTimeZone(KST));
        initService.dbInit();
    }

    private void setTimeZone(final TimeZone timeZone) {
        TimeZone.setDefault(timeZone);
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final CoachRepository coachRepository;
        private final CrewRepository crewRepository;
        private final AvailableDateTimeRepository availableDateTimeRepository;
        private final InterviewRepository interviewRepository;
        private final CommentRepository commentRepository;

        public void dbInit() {
            final ArrayList<Coach> coaches = new ArrayList<>();
            final ArrayList<Crew> crews = new ArrayList<>();

            // 1 ~ 10 더미 코치 생성
            addDefaultCoaches(coaches);

            long currentMemberId = 11;
            // 11 ~ 1000 미리 회원가입 되어있는 코치 생성
            while (currentMemberId <= 1000) {
                coaches.add(new Coach(currentMemberId, "코치" + currentMemberId, "코치" + currentMemberId,
                        "email" + currentMemberId + TEST_EMAIL,
                        "U1234567890" + currentMemberId,
                        "https://user-images.githubusercontent.com/54317630/184493934-9a2ba1bb-6051-4428-bb6a-5527c4f480d9.JPG",
                        "안녕하세요." + currentMemberId));
                currentMemberId++;
            }

            // 1001 ~ 2000 미리 회원가입 되어있는 크루 생성
            while (currentMemberId <= 2000) {
                crews.add(new Crew(currentMemberId, "크루이름" + currentMemberId, "크루" + currentMemberId,
                        "이메일" + currentMemberId,
                        "U1234567890" + currentMemberId,
                        "https://user-images.githubusercontent.com/54317630/184493934-9a2ba1bb-6051-4428-bb6a-5527c4f480d9.JPG"));
                currentMemberId++;
            }

            // 2001 ~ 2011 인터뷰 신청용 크루 생성
            while (currentMemberId <= 2011) {
                crews.add(new Crew(currentMemberId, "크루이름" + currentMemberId, "크루" + currentMemberId,
                        "이메일" + currentMemberId,
                        "U1234567890" + currentMemberId,
                        "https://user-images.githubusercontent.com/54317630/184493934-9a2ba1bb-6051-4428-bb6a-5527c4f480d9.JPG"));
                currentMemberId++;
            }

            // 크루, 코치 데이터 저장
            coachRepository.saveAll(coaches);
            crewRepository.saveAll(crews);

            // 인터뷰 더미데이터 생성


        }

        private void addDefaultCoaches(ArrayList<Coach> coaches) {
            coaches.add(new Coach(1L, "터놓고", "터노코", "ternoko.official@gmail.com",
                    "U03U8ETQ48Y",
                    "https://user-images.githubusercontent.com/54317630/184493934-9a2ba1bb-6051-4428-bb6a-5527c4f480d9.JPG",
                    "면담은 터놓고 하세요."));

            coaches.add(new Coach(2L, "이름", "네오", "네오" + COACH_EMAIL,
                    "U1234567891",
                    "https://user-images.githubusercontent.com/26570275/177680191-a4497404-c4cb-4f86-8c2c-f4f9c70bcaf7.png",
                    "안녕하세요."));
            coaches.add(new Coach(3L, "이름", "브라운", "브라운" + COACH_EMAIL,
                    "U1234567892",
                    "https://user-images.githubusercontent.com/26570275/177680196-744300be-eb1b-4331-a74f-fdc41ff869d0.png",
                    "안녕하세요."));
            coaches.add(new Coach(4L, "이름", "브리", "브리" + COACH_EMAIL,
                    "U1234567893",
                    "https://user-images.githubusercontent.com/43205258/177765431-63d39896-c8e1-42e8-a229-08309849f2ff.png",
                    "안녕하세요."));
            coaches.add(new Coach(5L, "이름", "왼손", "왼손" + COACH_EMAIL,
                    "U1234567894",
                    "https://user-images.githubusercontent.com/26570275/177680204-6d12cae9-f038-4503-b9de-a75f4b4de456.png",
                    "안녕하세요."));
            coaches.add(new Coach(6L, "이름", "워니", "워니" + COACH_EMAIL,
                    "U1234567895",
                    "https://user-images.githubusercontent.com/26570275/177680207-896f887b-5baf-47a5-b7ea-3b8c1bb5b8c3.png",
                    "안녕하세요."));
            coaches.add(new Coach(7L, "이름", "제이슨", "제이슨" + COACH_EMAIL,
                    "U1234567896",
                    "https://user-images.githubusercontent.com/43205258/177760748-5e0e9efd-d063-4639-9a6d-f48e3a76f919.png",
                    "안녕하세요."));
            coaches.add(new Coach(8L, "이름", "준", "준" + COACH_EMAIL,
                    "U1234567897",
                    "https://user-images.githubusercontent.com/26570275/177680212-63242449-1059-450b-96d8-a06b01a1aea5.png",
                    "안녕하세요."));
            coaches.add(new Coach(9L, "이름", "토미", "토미" + COACH_EMAIL,
                    "U1234567898",
                    "https://user-images.githubusercontent.com/26570275/177680217-764aa425-72cb-4b04-adeb-f110121cdf60.png",
                    "안녕하세요."));
            coaches.add(new Coach(10L, "이름", "공원", "공원" + COACH_EMAIL,
                    "U1234567890",
                    "https://user-images.githubusercontent.com/26570275/177680173-9bb25eac-5922-407b-889b-bb49ac392c2a.png",
                    "안녕하세요."));
        }
    }
}
