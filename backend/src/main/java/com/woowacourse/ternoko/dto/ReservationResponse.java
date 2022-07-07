package com.woowacourse.ternoko.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.woowacourse.ternoko.domain.Interview;
import com.woowacourse.ternoko.domain.Reservation;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@AllArgsConstructor
@Builder(builderMethodName = "reservationResponseBuilder")
public class ReservationResponse {

    private final Long id;
    private final String coachNickname;
    private final String imageUrl;
    private final String crewNickname;
    private final String interviewDate;
    private final String interviewStartTime;
    private final String interviewEndTime;
    private final String location;

    public static ReservationResponse from(final Reservation reservation) {
        final Interview interview = reservation.getInterview();

        return ReservationResponse.reservationResponseBuilder()
                .id(reservation.getId())
                .coachNickname(interview.getCoach().getNickname())
                .imageUrl(interview.getCoach().getImageUrl())
                .crewNickname(interview.getCrewNickname())
                .interviewDate(interview.getInterviewDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .interviewStartTime(interview.getInterviewStartTime().format(DateTimeFormatter.ofPattern("HH:mm")))
                .interviewEndTime(interview.getInterviewEndTime().format(DateTimeFormatter.ofPattern("HH:mm")))
                .location(interview.getLocation().getValue())
                .build();
    }
}
