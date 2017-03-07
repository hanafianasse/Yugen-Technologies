package fr.univbrest.dosi.spi.interceptor;


//@Aspect
//@Component
//public class LogInterceptor {
//
//
//    @Pointcut("execution(* fr.univbrest.dosi.spi..*.*(..))")
//    public void methodPointcut() {}
//
//    @Around("methodPointcut()")
//    public Object logger(ProceedingJoinPoint pjp) throws Throwable {
//    	// Récupération du logger et des paramètres utiles de la m"thode interceptée
//    			final Logger logger = LoggerFactory.getLogger(pjp.getThis().getClass());
//    			final String methodName = pjp.getSignature().getName();
//    			final String arguments = Arrays.toString(pjp.getArgs());
//
//    			try {
//    				// On loggue l'entrée dans la méthode
//    				if (logger.isDebugEnabled()) {
//    					logger.debug("{} - Entrée - paramètres {}", methodName, arguments);
//    				}
//
//    				// Exécution de la méthode
//    				return pjp.proceed();
//
//    			} catch (final Throwable t) {
//    				// On log l'exception puis on la relance pour traitement ultérieur
//    				logger.error("{} - Erreur - paramètres {}", methodName, arguments, t);
//    				throw t;
//
//    			} finally {
//    				// On log la sortie
//    				if (logger.isDebugEnabled()) {
//    					logger.debug("{} - Sortie - paramètres {}", methodName, arguments);
//    				}
//    			}
//       /* StopWatch sw = new StopWatch();
//        String name = pjp.getSignature().getName();
//        try {
//            sw.start();
//            return pjp.proceed();
//        } finally {
//            sw.stop();
//            logger.info("STOPWATCH: " + sw.getTime() + " - " + name);
//        }*/
//    }
// }