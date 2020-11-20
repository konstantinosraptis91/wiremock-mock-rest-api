package kraptis91.wiremock;

/** @author Konstantinos Raptis [kraptis at unipi.gr] on 20/11/2020. */
public class TaskFactory {

  public static GetTask createGetFromECertisTask() {
    return new GetTaskImpl();
  }
}
