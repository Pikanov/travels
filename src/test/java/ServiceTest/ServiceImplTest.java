package ServiceTest;

import com.joinup.repository.TravelVoucherRepository;
import com.joinup.service.Impl.TravelVoucherServiceImpl;
import com.joinup.util.QueryParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ServiceImplTest {

    @InjectMocks
    TravelVoucherServiceImpl travelVoucherService;

    @Mock
    private TravelVoucherRepository travelVoucherRepository;

    @Test
    public void defineTourInvoke() {
        QueryParam queryParam = new QueryParam();
        queryParam.setFood(true);
        queryParam.setNumberOfDays(21);
        queryParam.setTypeOfTransport(1);

        Mockito.doReturn(null).when(travelVoucherRepository).defineTour(queryParam);
        travelVoucherService.defineTour(queryParam);
        verify(travelVoucherRepository).defineTour(queryParam);
    }

    @Test
    public void defineTourInvokeNotNull() {

        travelVoucherService.defineTour(null);
        verify(travelVoucherRepository, never()).defineTour(null);
    }
}
