package jolt.template.configurations;

import io.github.t1willi.injector.annotation.Configuration;
import io.github.t1willi.security.config.SecurityConfiguration;
import io.github.t1willi.security.policies.ContentSecurityPolicy;
import io.github.t1willi.security.policies.FrameOptionsPolicy;
import io.github.t1willi.security.policies.HstsPolicy;
import io.github.t1willi.security.policies.ReferrerPolicy;
import io.github.t1willi.security.policies.XssProtectionPolicy;

@Configuration
public class SecurityConfig extends SecurityConfiguration {

        @Override
        public void configure() {
                withCORS()
                                .allowedOrigins("*")
                                .allowedMethods("GET", "POST", "PUT", "DELETE")
                                .allowedHeaders("Origin", "Content-Type", "Accept", "Authorization")
                                .allowedCredentials(false)
                                .maxAge(3600);

                withHeaders()
                                .withXssProtection(XssProtectionPolicy.ENABLE_BLOCK)
                                .withFrameOptions(FrameOptionsPolicy.DENY)
                                .withHsts(HstsPolicy.ONE_YEAR_WITH_SUBDOMAINS_PRELOAD)
                                .withReferrerPolicy(ReferrerPolicy.STRICT_ORIGIN)
                                .withCSP()
                                .withDefaultSources(ContentSecurityPolicy.SELF)
                                .withStyleSources(ContentSecurityPolicy.SELF, ContentSecurityPolicy.GOOGLE_FONTS,
                                                ContentSecurityPolicy.CDNJS, ContentSecurityPolicy.JSDELIVR)
                                .withScriptSources(ContentSecurityPolicy.SELF)
                                .withFontSources(ContentSecurityPolicy.SELF, ContentSecurityPolicy.GOOGLE_FONTS,
                                                ContentSecurityPolicy.JSDELIVR, ContentSecurityPolicy.CDNJS)
                                .withImageSources(ContentSecurityPolicy.SELF, ContentSecurityPolicy.DATA)
                                .withConnectSources(ContentSecurityPolicy.SELF, "*")
                                .withFrameSources(ContentSecurityPolicy.SELF, "*")
                                .withMediaSources(ContentSecurityPolicy.SELF, "*")
                                .and()
                                .httpsOnly(true);

                withCSRF().enable().addIgnoreUrlPatterns("/products");
                withNonce().enable();
                withMaxRequest(60);
        }
}
