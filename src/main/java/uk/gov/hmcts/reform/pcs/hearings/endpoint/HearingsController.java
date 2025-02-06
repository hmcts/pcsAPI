package uk.gov.hmcts.reform.pcs.hearings.endpoint;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static uk.gov.hmcts.reform.pcs.hearings.constants.HearingConstants.SERVICE_AUTHORIZATION;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.hmcts.reform.pcs.hearings.model.DeleteHearingRequest;
import uk.gov.hmcts.reform.pcs.hearings.model.GetHearingsResponse;
import uk.gov.hmcts.reform.pcs.hearings.model.HearingRequest;
import uk.gov.hmcts.reform.pcs.hearings.model.HearingResponse;
import uk.gov.hmcts.reform.pcs.hearings.model.UpdateHearingRequest;
import uk.gov.hmcts.reform.pcs.hearings.service.HmcHearingService;

/**
 * This controller will just pass through the input to HMC currently,
 * request and response will change when actual functionality is developed.
 */
@RestController
@RequestMapping("/hearing")
public class HearingsController {

    private final HmcHearingService hmcHearingService;

    public HearingsController(HmcHearingService hmcHearingService) {
        this.hmcHearingService = hmcHearingService;
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    HearingResponse createHearing(
        @RequestHeader(AUTHORIZATION) String authorisation,
        @RequestHeader(SERVICE_AUTHORIZATION) String serviceAuthorization,
        @RequestBody HearingRequest hearingPayload) {
        return hmcHearingService.createHearing(authorisation, hearingPayload);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    HearingResponse updateHearing(
        @RequestHeader(AUTHORIZATION) String authorisation,
        @RequestHeader(SERVICE_AUTHORIZATION) String serviceAuthorization,
        @PathVariable String id,
        @RequestBody UpdateHearingRequest hearingPayload) {
        return hmcHearingService.updateHearing(authorisation, id, hearingPayload);
    }

    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    HearingResponse deleteHearing(
        @RequestHeader(AUTHORIZATION) String authorisation,
        @RequestHeader(SERVICE_AUTHORIZATION) String serviceAuthorization,
        @PathVariable String id,
        @RequestBody DeleteHearingRequest hearingDeletePayload) {
        return hmcHearingService.deleteHearing(authorisation, id, hearingDeletePayload);
    }

    @GetMapping(value = "/{id}")
    GetHearingsResponse getHearing(
        @RequestHeader(AUTHORIZATION) String authorisation,
        @RequestHeader(SERVICE_AUTHORIZATION) String serviceAuthorization,
        @PathVariable String id) {
        return hmcHearingService.getHearing(authorisation, id);
    }
}
